/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See LICENSE in the project root for
 * license information.
 */
package com.microsoft.azure.spring.autoconfigure.aad;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

import javax.naming.ServiceUnavailableException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.core.OAuth2AccessToken;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.microsoft.aad.adal4j.AuthenticationContext;
import com.microsoft.aad.adal4j.AuthenticationResult;
import com.microsoft.aad.adal4j.ClientCredential;
import com.microsoft.aad.adal4j.UserAssertion;
import com.microsoft.azure.spring.autoconfigure.aad.AADAuthenticationProperties.UserGroupProperties;
import com.nimbusds.oauth2.sdk.http.HTTPResponse;

import groovy.util.logging.Slf4j;

@Slf4j
public class AzureADGraphClient {
	private static final SimpleGrantedAuthority DEFAULT_AUTHORITY = new SimpleGrantedAuthority("ROLE_USER");
	private static final String DEFAULT_ROLE_PREFIX = "ROLE_";
	private static final String REQUEST_ID_SUFFIX = "aadfeed5";

	private final String clientId;
	private final String clientSecret;
	private final ServiceEndpoints serviceEndpoints;
	private final AADAuthenticationProperties aadAuthenticationProperties;

	private static final String V2_VERSION_ENV_FLAG = "v2-graph";
	private boolean aadMicrosoftGraphApiBool;

	public AzureADGraphClient(ClientCredential clientCredential, AADAuthenticationProperties aadAuthProps,
			ServiceEndpointsProperties serviceEndpointsProps) {
		this.clientId = clientCredential.getClientId();
		this.clientSecret = clientCredential.getClientSecret();
		this.aadAuthenticationProperties = aadAuthProps;
		this.serviceEndpoints = serviceEndpointsProps.getServiceEndpoints(aadAuthProps.getEnvironment());

		this.initAADMicrosoftGraphApiBool(aadAuthProps.getEnvironment());
	}

	private void initAADMicrosoftGraphApiBool(String endpointEnv) {
		this.aadMicrosoftGraphApiBool = false;
		if (endpointEnv.contains(V2_VERSION_ENV_FLAG)) {
			this.aadMicrosoftGraphApiBool = true;
		}
	}

	private String getUserMemberships(String accessToken, Optional<String> odataNextLink) throws IOException {
		URL url = buildURL(odataNextLink);

		final HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		// Set the appropriate header fields in the request header.

		if (this.aadMicrosoftGraphApiBool) {
			conn.setRequestMethod(HttpMethod.GET.toString());
			conn.setRequestProperty(HttpHeaders.AUTHORIZATION,
					String.format("%s %s", OAuth2AccessToken.TokenType.BEARER.getValue(), accessToken));
			conn.setRequestProperty(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
			conn.setRequestProperty(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_FORM_URLENCODED_VALUE);
		} else {
			conn.setRequestMethod(HttpMethod.GET.toString());
			conn.setRequestProperty("api-version", "1.6");
			conn.setRequestProperty(HttpHeaders.AUTHORIZATION, String.format("%s", accessToken));
			conn.setRequestProperty(HttpHeaders.ACCEPT, "application/json;odata=minimalmetadata");
		}
		final String responseInJson = getResponseStringFromConn(conn);
		final int responseCode = conn.getResponseCode();
		if (responseCode == HTTPResponse.SC_OK) {
			return responseInJson;
		} else {
			throw new IllegalStateException(
					"Response is not " + HTTPResponse.SC_OK + ", response json: " + responseInJson);
		}
	}

	/**
	 * Builds the URL for the group membership request
	 *
	 * @param odataNextLink - the optional next link from the previous response.
	 *                      Empty if it's the first request
	 *
	 * @return the url to fetch the groups that the user is a member of
	 *
	 * @throws MalformedURLException
	 */
	private URL buildURL(Optional<String> odataNextLink) throws MalformedURLException {
		URL url;

		if (odataNextLink.isPresent()) {
			if (this.aadMicrosoftGraphApiBool) {
				url = new URL(odataNextLink.get());
			} else {
				String skipToken = getSkipTokenFromLink(odataNextLink.get());
				url = new URL(serviceEndpoints.getAadMembershipRestUri() + "&" + skipToken);
			}
		} else {
			url = new URL(serviceEndpoints.getAadMembershipRestUri());
		}

		return url;
	}

	/**
	 * Extracts the skip token from odata.nextLink
	 *
	 * @param odataNextLink - containing the skip token
	 *
	 * @return the skip token to append to the next request
	 */
	private String getSkipTokenFromLink(String odataNextLink) {
		return odataNextLink.split("/memberOf\\?")[1];
	}

	private static String getResponseStringFromConn(HttpURLConnection conn) throws IOException {

		try (BufferedReader reader = new BufferedReader(
				new InputStreamReader(conn.getInputStream(), StandardCharsets.UTF_8))) {
			final StringBuilder stringBuffer = new StringBuilder();
			String line = "";
			while ((line = reader.readLine()) != null) {
				stringBuffer.append(line);
			}
			return stringBuffer.toString();
		}
	}

	public List<UserGroup> getGroups(String graphApiToken) throws IOException {
		return loadUserGroups(graphApiToken);
	}

	private List<UserGroup> loadUserGroups(String graphApiToken) throws IOException {
		final List<UserGroup> lUserGroups = new ArrayList<>();
		final ObjectMapper objectMapper = JacksonObjectMapperFactory.getInstance();
		objectMapper.registerModule(new Jdk8Module());
		String responseInJson = getUserMemberships(graphApiToken, Optional.empty());
		UserGroups groupsFromJson = objectMapper.readValue(responseInJson, UserGroups.class);

		if (groupsFromJson.getValue() != null) {
			lUserGroups.addAll(groupsFromJson.getValue().stream().filter(this::isMatchingUserGroupKey)
					.collect(Collectors.toList()));
		}
		while (groupsFromJson.getOdataNextLink().isPresent()) {
			responseInJson = getUserMemberships(graphApiToken, groupsFromJson.getOdataNextLink());
			groupsFromJson = objectMapper.readValue(responseInJson, UserGroups.class);
			lUserGroups.addAll(groupsFromJson.getValue().stream().filter(this::isMatchingUserGroupKey)
					.collect(Collectors.toList()));
		}
		return lUserGroups;
	}

	/**
	 * Checks that the JSON Node is a valid User Group to extract User Groups from
	 *
	 * @param node - json node to look for a key/value to equate against the
	 *             {@link UserGroupProperties}
	 *
	 * @return true if the json node contains the correct key, and expected value to
	 *         identify a user group.
	 */
	private boolean isMatchingUserGroupKey(final UserGroup group) {
		return group.getObjectType().equals(aadAuthenticationProperties.getUserGroup().getValue());
	}

	public Set<GrantedAuthority> getGrantedAuthorities(String graphApiToken) throws IOException {
		// Fetch the authority information from the protected resource using accessToken
		final List<UserGroup> groups = getGroups(graphApiToken);

		// Map the authority information to one or more GrantedAuthority's and add it to
		// mappedAuthorities
		return convertGroupsToGrantedAuthorities(groups);
	}


	/**
	 * Converts UserGroup list to Set of GrantedAuthorities
	 *
	 * @param groups
	 * @return
	 */
	public Set<GrantedAuthority> convertGroupsToGrantedAuthorities(final List<UserGroup> groups) {
		// Map the authority information to one or more GrantedAuthority's and add it to
		// mappedAuthorities
		final Set<GrantedAuthority> mappedAuthorities = groups.stream().filter(this::isValidUserGroupToGrantAuthority)
				.map(userGroup -> new SimpleGrantedAuthority(DEFAULT_ROLE_PREFIX + userGroup.getDisplayName()))
				.collect(Collectors.toCollection(LinkedHashSet::new));
		if (mappedAuthorities.isEmpty()) {
			mappedAuthorities.add(DEFAULT_AUTHORITY);
		}

		return mappedAuthorities;
	}

	/**
	 * Determines if this is a valid {@link UserGroup} to build to a
	 * GrantedAuthority.
	 * <p>
	 * If the {@link UserGroupProperties#getAllowedGroups()} or the
	 * {@link AADAuthenticationProperties#getActiveDirectoryGroups()} contains the
	 * {@link UserGroup#getDisplayName()} return true.
	 *
	 * @param group - User Group to check if valid to grant an authority to.
	 *
	 * @return true if either of the allowed-groups or active-directory-groups
	 *         contains the UserGroup display name
	 */
	private boolean isValidUserGroupToGrantAuthority(final UserGroup group) {
		return aadAuthenticationProperties.getUserGroup().getAllowedGroups().contains(group.getDisplayName())
				|| aadAuthenticationProperties.getActiveDirectoryGroups().contains(group.getDisplayName());
	}

	public AuthenticationResult acquireTokenForGraphApi(String idToken, String tenantId)
			throws MalformedURLException, ServiceUnavailableException, InterruptedException, ExecutionException {

		final ClientCredential credential = new ClientCredential(clientId, clientSecret);
		final UserAssertion assertion = new UserAssertion(idToken);

		AuthenticationResult result = null;
		ExecutorService service = null;
		try {
			service = Executors.newFixedThreadPool(1);
			final AuthenticationContext context = new AuthenticationContext(
					serviceEndpoints.getAadSigninUri() + tenantId + "/", true, service);
			context.setCorrelationId(getCorrelationId());
			final Future<AuthenticationResult> future = context.acquireToken(serviceEndpoints.getAadGraphApiUri(),
					assertion, credential, null);
			result = future.get();
		} finally {
			if (service != null) {
				service.shutdown();
			}
		}

		if (result == null) {
			throw new ServiceUnavailableException("unable to acquire on-behalf-of token for client " + clientId);
		}
		return result;
	}

	private static String getCorrelationId() {
		final String uuid = UUID.randomUUID().toString();
		return uuid.substring(0, uuid.length() - REQUEST_ID_SUFFIX.length()) + REQUEST_ID_SUFFIX;
	}
}
