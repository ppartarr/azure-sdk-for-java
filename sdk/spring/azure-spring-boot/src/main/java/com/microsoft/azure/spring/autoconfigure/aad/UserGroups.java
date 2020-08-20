/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See LICENSE in the project root for
 * license information.
 */
package com.microsoft.azure.spring.autoconfigure.aad;

import java.util.List;
import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserGroups {

	@JsonProperty("odata.nextLink")
	private Optional<String> odataNextLink;
	private List<UserGroup> value;

	public UserGroups(Optional<String> odataNextLink, List<UserGroup> value) {
		this.odataNextLink = odataNextLink;
		this.value = value;
	}

	public Optional<String> getOdataNextLink() {
		return odataNextLink;
	}

	public List<UserGroup> getValue() {
		return value;
	}
}
