/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.applicationinsights.v2015_05_01.implementation;

import retrofit2.Retrofit;
import com.google.common.reflect.TypeToken;
import com.microsoft.azure.CloudException;
import com.microsoft.rest.ServiceCallback;
import com.microsoft.rest.ServiceFuture;
import com.microsoft.rest.ServiceResponse;
import com.microsoft.rest.Validator;
import java.io.IOException;
import java.util.List;
import okhttp3.ResponseBody;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.PUT;
import retrofit2.http.Query;
import retrofit2.Response;
import rx.functions.Func1;
import rx.Observable;

/**
 * An instance of this class provides access to all the operations defined
 * in ProactiveDetectionConfigurations.
 */
public class ProactiveDetectionConfigurationsInner {
    /** The Retrofit service to perform REST calls. */
    private ProactiveDetectionConfigurationsService service;
    /** The service client containing this operation class. */
    private ApplicationInsightsManagementClientImpl client;

    /**
     * Initializes an instance of ProactiveDetectionConfigurationsInner.
     *
     * @param retrofit the Retrofit instance built from a Retrofit Builder.
     * @param client the instance of the service client containing this operation class.
     */
    public ProactiveDetectionConfigurationsInner(Retrofit retrofit, ApplicationInsightsManagementClientImpl client) {
        this.service = retrofit.create(ProactiveDetectionConfigurationsService.class);
        this.client = client;
    }

    /**
     * The interface defining all the services for ProactiveDetectionConfigurations to be
     * used by Retrofit to perform actually REST calls.
     */
    interface ProactiveDetectionConfigurationsService {
        @Headers({ "Content-Type: application/json; charset=utf-8", "x-ms-logging-context: com.microsoft.azure.management.applicationinsights.v2015_05_01.ProactiveDetectionConfigurations list" })
        @GET("subscriptions/{subscriptionId}/resourceGroups/{resourceGroupName}/providers/Microsoft.Insights/components/{resourceName}/ProactiveDetectionConfigs")
        Observable<Response<ResponseBody>> list(@Path("resourceGroupName") String resourceGroupName, @Path("subscriptionId") String subscriptionId, @Path("resourceName") String resourceName, @Query("api-version") String apiVersion, @Header("accept-language") String acceptLanguage, @Header("User-Agent") String userAgent);

        @Headers({ "Content-Type: application/json; charset=utf-8", "x-ms-logging-context: com.microsoft.azure.management.applicationinsights.v2015_05_01.ProactiveDetectionConfigurations get" })
        @GET("subscriptions/{subscriptionId}/resourceGroups/{resourceGroupName}/providers/Microsoft.Insights/components/{resourceName}/ProactiveDetectionConfigs/{ConfigurationId}")
        Observable<Response<ResponseBody>> get(@Path("resourceGroupName") String resourceGroupName, @Path("subscriptionId") String subscriptionId, @Path("resourceName") String resourceName, @Path("ConfigurationId") String configurationId, @Query("api-version") String apiVersion, @Header("accept-language") String acceptLanguage, @Header("User-Agent") String userAgent);

        @Headers({ "Content-Type: application/json; charset=utf-8", "x-ms-logging-context: com.microsoft.azure.management.applicationinsights.v2015_05_01.ProactiveDetectionConfigurations update" })
        @PUT("subscriptions/{subscriptionId}/resourceGroups/{resourceGroupName}/providers/Microsoft.Insights/components/{resourceName}/ProactiveDetectionConfigs/{ConfigurationId}")
        Observable<Response<ResponseBody>> update(@Path("resourceGroupName") String resourceGroupName, @Path("subscriptionId") String subscriptionId, @Path("resourceName") String resourceName, @Path("ConfigurationId") String configurationId, @Query("api-version") String apiVersion, @Body ApplicationInsightsComponentProactiveDetectionConfigurationInner proactiveDetectionProperties, @Header("accept-language") String acceptLanguage, @Header("User-Agent") String userAgent);

    }

    /**
     * Gets a list of ProactiveDetection configurations of an Application Insights component.
     *
     * @param resourceGroupName The name of the resource group.
     * @param resourceName The name of the Application Insights component resource.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @throws CloudException thrown if the request is rejected by server
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent
     * @return the List&lt;ApplicationInsightsComponentProactiveDetectionConfigurationInner&gt; object if successful.
     */
    public List<ApplicationInsightsComponentProactiveDetectionConfigurationInner> list(String resourceGroupName, String resourceName) {
        return listWithServiceResponseAsync(resourceGroupName, resourceName).toBlocking().single().body();
    }

    /**
     * Gets a list of ProactiveDetection configurations of an Application Insights component.
     *
     * @param resourceGroupName The name of the resource group.
     * @param resourceName The name of the Application Insights component resource.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the {@link ServiceFuture} object
     */
    public ServiceFuture<List<ApplicationInsightsComponentProactiveDetectionConfigurationInner>> listAsync(String resourceGroupName, String resourceName, final ServiceCallback<List<ApplicationInsightsComponentProactiveDetectionConfigurationInner>> serviceCallback) {
        return ServiceFuture.fromResponse(listWithServiceResponseAsync(resourceGroupName, resourceName), serviceCallback);
    }

    /**
     * Gets a list of ProactiveDetection configurations of an Application Insights component.
     *
     * @param resourceGroupName The name of the resource group.
     * @param resourceName The name of the Application Insights component resource.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the List&lt;ApplicationInsightsComponentProactiveDetectionConfigurationInner&gt; object
     */
    public Observable<List<ApplicationInsightsComponentProactiveDetectionConfigurationInner>> listAsync(String resourceGroupName, String resourceName) {
        return listWithServiceResponseAsync(resourceGroupName, resourceName).map(new Func1<ServiceResponse<List<ApplicationInsightsComponentProactiveDetectionConfigurationInner>>, List<ApplicationInsightsComponentProactiveDetectionConfigurationInner>>() {
            @Override
            public List<ApplicationInsightsComponentProactiveDetectionConfigurationInner> call(ServiceResponse<List<ApplicationInsightsComponentProactiveDetectionConfigurationInner>> response) {
                return response.body();
            }
        });
    }

    /**
     * Gets a list of ProactiveDetection configurations of an Application Insights component.
     *
     * @param resourceGroupName The name of the resource group.
     * @param resourceName The name of the Application Insights component resource.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the List&lt;ApplicationInsightsComponentProactiveDetectionConfigurationInner&gt; object
     */
    public Observable<ServiceResponse<List<ApplicationInsightsComponentProactiveDetectionConfigurationInner>>> listWithServiceResponseAsync(String resourceGroupName, String resourceName) {
        if (resourceGroupName == null) {
            throw new IllegalArgumentException("Parameter resourceGroupName is required and cannot be null.");
        }
        if (this.client.subscriptionId() == null) {
            throw new IllegalArgumentException("Parameter this.client.subscriptionId() is required and cannot be null.");
        }
        if (resourceName == null) {
            throw new IllegalArgumentException("Parameter resourceName is required and cannot be null.");
        }
        if (this.client.apiVersion() == null) {
            throw new IllegalArgumentException("Parameter this.client.apiVersion() is required and cannot be null.");
        }
        return service.list(resourceGroupName, this.client.subscriptionId(), resourceName, this.client.apiVersion(), this.client.acceptLanguage(), this.client.userAgent())
            .flatMap(new Func1<Response<ResponseBody>, Observable<ServiceResponse<List<ApplicationInsightsComponentProactiveDetectionConfigurationInner>>>>() {
                @Override
                public Observable<ServiceResponse<List<ApplicationInsightsComponentProactiveDetectionConfigurationInner>>> call(Response<ResponseBody> response) {
                    try {
                        ServiceResponse<List<ApplicationInsightsComponentProactiveDetectionConfigurationInner>> clientResponse = listDelegate(response);
                        return Observable.just(clientResponse);
                    } catch (Throwable t) {
                        return Observable.error(t);
                    }
                }
            });
    }

    private ServiceResponse<List<ApplicationInsightsComponentProactiveDetectionConfigurationInner>> listDelegate(Response<ResponseBody> response) throws CloudException, IOException, IllegalArgumentException {
        return this.client.restClient().responseBuilderFactory().<List<ApplicationInsightsComponentProactiveDetectionConfigurationInner>, CloudException>newInstance(this.client.serializerAdapter())
                .register(200, new TypeToken<List<ApplicationInsightsComponentProactiveDetectionConfigurationInner>>() { }.getType())
                .registerError(CloudException.class)
                .build(response);
    }

    /**
     * Get the ProactiveDetection configuration for this configuration id.
     *
     * @param resourceGroupName The name of the resource group.
     * @param resourceName The name of the Application Insights component resource.
     * @param configurationId The ProactiveDetection configuration ID. This is unique within a Application Insights component.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @throws CloudException thrown if the request is rejected by server
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent
     * @return the ApplicationInsightsComponentProactiveDetectionConfigurationInner object if successful.
     */
    public ApplicationInsightsComponentProactiveDetectionConfigurationInner get(String resourceGroupName, String resourceName, String configurationId) {
        return getWithServiceResponseAsync(resourceGroupName, resourceName, configurationId).toBlocking().single().body();
    }

    /**
     * Get the ProactiveDetection configuration for this configuration id.
     *
     * @param resourceGroupName The name of the resource group.
     * @param resourceName The name of the Application Insights component resource.
     * @param configurationId The ProactiveDetection configuration ID. This is unique within a Application Insights component.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the {@link ServiceFuture} object
     */
    public ServiceFuture<ApplicationInsightsComponentProactiveDetectionConfigurationInner> getAsync(String resourceGroupName, String resourceName, String configurationId, final ServiceCallback<ApplicationInsightsComponentProactiveDetectionConfigurationInner> serviceCallback) {
        return ServiceFuture.fromResponse(getWithServiceResponseAsync(resourceGroupName, resourceName, configurationId), serviceCallback);
    }

    /**
     * Get the ProactiveDetection configuration for this configuration id.
     *
     * @param resourceGroupName The name of the resource group.
     * @param resourceName The name of the Application Insights component resource.
     * @param configurationId The ProactiveDetection configuration ID. This is unique within a Application Insights component.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the ApplicationInsightsComponentProactiveDetectionConfigurationInner object
     */
    public Observable<ApplicationInsightsComponentProactiveDetectionConfigurationInner> getAsync(String resourceGroupName, String resourceName, String configurationId) {
        return getWithServiceResponseAsync(resourceGroupName, resourceName, configurationId).map(new Func1<ServiceResponse<ApplicationInsightsComponentProactiveDetectionConfigurationInner>, ApplicationInsightsComponentProactiveDetectionConfigurationInner>() {
            @Override
            public ApplicationInsightsComponentProactiveDetectionConfigurationInner call(ServiceResponse<ApplicationInsightsComponentProactiveDetectionConfigurationInner> response) {
                return response.body();
            }
        });
    }

    /**
     * Get the ProactiveDetection configuration for this configuration id.
     *
     * @param resourceGroupName The name of the resource group.
     * @param resourceName The name of the Application Insights component resource.
     * @param configurationId The ProactiveDetection configuration ID. This is unique within a Application Insights component.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the ApplicationInsightsComponentProactiveDetectionConfigurationInner object
     */
    public Observable<ServiceResponse<ApplicationInsightsComponentProactiveDetectionConfigurationInner>> getWithServiceResponseAsync(String resourceGroupName, String resourceName, String configurationId) {
        if (resourceGroupName == null) {
            throw new IllegalArgumentException("Parameter resourceGroupName is required and cannot be null.");
        }
        if (this.client.subscriptionId() == null) {
            throw new IllegalArgumentException("Parameter this.client.subscriptionId() is required and cannot be null.");
        }
        if (resourceName == null) {
            throw new IllegalArgumentException("Parameter resourceName is required and cannot be null.");
        }
        if (configurationId == null) {
            throw new IllegalArgumentException("Parameter configurationId is required and cannot be null.");
        }
        if (this.client.apiVersion() == null) {
            throw new IllegalArgumentException("Parameter this.client.apiVersion() is required and cannot be null.");
        }
        return service.get(resourceGroupName, this.client.subscriptionId(), resourceName, configurationId, this.client.apiVersion(), this.client.acceptLanguage(), this.client.userAgent())
            .flatMap(new Func1<Response<ResponseBody>, Observable<ServiceResponse<ApplicationInsightsComponentProactiveDetectionConfigurationInner>>>() {
                @Override
                public Observable<ServiceResponse<ApplicationInsightsComponentProactiveDetectionConfigurationInner>> call(Response<ResponseBody> response) {
                    try {
                        ServiceResponse<ApplicationInsightsComponentProactiveDetectionConfigurationInner> clientResponse = getDelegate(response);
                        return Observable.just(clientResponse);
                    } catch (Throwable t) {
                        return Observable.error(t);
                    }
                }
            });
    }

    private ServiceResponse<ApplicationInsightsComponentProactiveDetectionConfigurationInner> getDelegate(Response<ResponseBody> response) throws CloudException, IOException, IllegalArgumentException {
        return this.client.restClient().responseBuilderFactory().<ApplicationInsightsComponentProactiveDetectionConfigurationInner, CloudException>newInstance(this.client.serializerAdapter())
                .register(200, new TypeToken<ApplicationInsightsComponentProactiveDetectionConfigurationInner>() { }.getType())
                .registerError(CloudException.class)
                .build(response);
    }

    /**
     * Update the ProactiveDetection configuration for this configuration id.
     *
     * @param resourceGroupName The name of the resource group.
     * @param resourceName The name of the Application Insights component resource.
     * @param configurationId The ProactiveDetection configuration ID. This is unique within a Application Insights component.
     * @param proactiveDetectionProperties Properties that need to be specified to update the ProactiveDetection configuration.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @throws CloudException thrown if the request is rejected by server
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent
     * @return the ApplicationInsightsComponentProactiveDetectionConfigurationInner object if successful.
     */
    public ApplicationInsightsComponentProactiveDetectionConfigurationInner update(String resourceGroupName, String resourceName, String configurationId, ApplicationInsightsComponentProactiveDetectionConfigurationInner proactiveDetectionProperties) {
        return updateWithServiceResponseAsync(resourceGroupName, resourceName, configurationId, proactiveDetectionProperties).toBlocking().single().body();
    }

    /**
     * Update the ProactiveDetection configuration for this configuration id.
     *
     * @param resourceGroupName The name of the resource group.
     * @param resourceName The name of the Application Insights component resource.
     * @param configurationId The ProactiveDetection configuration ID. This is unique within a Application Insights component.
     * @param proactiveDetectionProperties Properties that need to be specified to update the ProactiveDetection configuration.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the {@link ServiceFuture} object
     */
    public ServiceFuture<ApplicationInsightsComponentProactiveDetectionConfigurationInner> updateAsync(String resourceGroupName, String resourceName, String configurationId, ApplicationInsightsComponentProactiveDetectionConfigurationInner proactiveDetectionProperties, final ServiceCallback<ApplicationInsightsComponentProactiveDetectionConfigurationInner> serviceCallback) {
        return ServiceFuture.fromResponse(updateWithServiceResponseAsync(resourceGroupName, resourceName, configurationId, proactiveDetectionProperties), serviceCallback);
    }

    /**
     * Update the ProactiveDetection configuration for this configuration id.
     *
     * @param resourceGroupName The name of the resource group.
     * @param resourceName The name of the Application Insights component resource.
     * @param configurationId The ProactiveDetection configuration ID. This is unique within a Application Insights component.
     * @param proactiveDetectionProperties Properties that need to be specified to update the ProactiveDetection configuration.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the ApplicationInsightsComponentProactiveDetectionConfigurationInner object
     */
    public Observable<ApplicationInsightsComponentProactiveDetectionConfigurationInner> updateAsync(String resourceGroupName, String resourceName, String configurationId, ApplicationInsightsComponentProactiveDetectionConfigurationInner proactiveDetectionProperties) {
        return updateWithServiceResponseAsync(resourceGroupName, resourceName, configurationId, proactiveDetectionProperties).map(new Func1<ServiceResponse<ApplicationInsightsComponentProactiveDetectionConfigurationInner>, ApplicationInsightsComponentProactiveDetectionConfigurationInner>() {
            @Override
            public ApplicationInsightsComponentProactiveDetectionConfigurationInner call(ServiceResponse<ApplicationInsightsComponentProactiveDetectionConfigurationInner> response) {
                return response.body();
            }
        });
    }

    /**
     * Update the ProactiveDetection configuration for this configuration id.
     *
     * @param resourceGroupName The name of the resource group.
     * @param resourceName The name of the Application Insights component resource.
     * @param configurationId The ProactiveDetection configuration ID. This is unique within a Application Insights component.
     * @param proactiveDetectionProperties Properties that need to be specified to update the ProactiveDetection configuration.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the ApplicationInsightsComponentProactiveDetectionConfigurationInner object
     */
    public Observable<ServiceResponse<ApplicationInsightsComponentProactiveDetectionConfigurationInner>> updateWithServiceResponseAsync(String resourceGroupName, String resourceName, String configurationId, ApplicationInsightsComponentProactiveDetectionConfigurationInner proactiveDetectionProperties) {
        if (resourceGroupName == null) {
            throw new IllegalArgumentException("Parameter resourceGroupName is required and cannot be null.");
        }
        if (this.client.subscriptionId() == null) {
            throw new IllegalArgumentException("Parameter this.client.subscriptionId() is required and cannot be null.");
        }
        if (resourceName == null) {
            throw new IllegalArgumentException("Parameter resourceName is required and cannot be null.");
        }
        if (configurationId == null) {
            throw new IllegalArgumentException("Parameter configurationId is required and cannot be null.");
        }
        if (this.client.apiVersion() == null) {
            throw new IllegalArgumentException("Parameter this.client.apiVersion() is required and cannot be null.");
        }
        if (proactiveDetectionProperties == null) {
            throw new IllegalArgumentException("Parameter proactiveDetectionProperties is required and cannot be null.");
        }
        Validator.validate(proactiveDetectionProperties);
        return service.update(resourceGroupName, this.client.subscriptionId(), resourceName, configurationId, this.client.apiVersion(), proactiveDetectionProperties, this.client.acceptLanguage(), this.client.userAgent())
            .flatMap(new Func1<Response<ResponseBody>, Observable<ServiceResponse<ApplicationInsightsComponentProactiveDetectionConfigurationInner>>>() {
                @Override
                public Observable<ServiceResponse<ApplicationInsightsComponentProactiveDetectionConfigurationInner>> call(Response<ResponseBody> response) {
                    try {
                        ServiceResponse<ApplicationInsightsComponentProactiveDetectionConfigurationInner> clientResponse = updateDelegate(response);
                        return Observable.just(clientResponse);
                    } catch (Throwable t) {
                        return Observable.error(t);
                    }
                }
            });
    }

    private ServiceResponse<ApplicationInsightsComponentProactiveDetectionConfigurationInner> updateDelegate(Response<ResponseBody> response) throws CloudException, IOException, IllegalArgumentException {
        return this.client.restClient().responseBuilderFactory().<ApplicationInsightsComponentProactiveDetectionConfigurationInner, CloudException>newInstance(this.client.serializerAdapter())
                .register(200, new TypeToken<ApplicationInsightsComponentProactiveDetectionConfigurationInner>() { }.getType())
                .registerError(CloudException.class)
                .build(response);
    }

}