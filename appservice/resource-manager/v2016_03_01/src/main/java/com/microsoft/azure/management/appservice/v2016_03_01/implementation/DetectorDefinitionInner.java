/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.appservice.v2016_03_01.implementation;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.microsoft.rest.serializer.JsonFlatten;
import com.microsoft.azure.management.appservice.v2016_03_01.ProxyOnlyResource;

/**
 * Class representing detector definition.
 */
@JsonFlatten
public class DetectorDefinitionInner extends ProxyOnlyResource {
    /**
     * Display name of the detector.
     */
    @JsonProperty(value = "properties.displayName", access = JsonProperty.Access.WRITE_ONLY)
    private String displayName;

    /**
     * Description of the detector.
     */
    @JsonProperty(value = "properties.description", access = JsonProperty.Access.WRITE_ONLY)
    private String description;

    /**
     * Detector Rank.
     */
    @JsonProperty(value = "properties.rank", access = JsonProperty.Access.WRITE_ONLY)
    private Double rank;

    /**
     * Flag representing whether detector is enabled or not.
     */
    @JsonProperty(value = "properties.isEnabled", access = JsonProperty.Access.WRITE_ONLY)
    private Boolean isEnabled;

    /**
     * Get display name of the detector.
     *
     * @return the displayName value
     */
    public String displayName() {
        return this.displayName;
    }

    /**
     * Get description of the detector.
     *
     * @return the description value
     */
    public String description() {
        return this.description;
    }

    /**
     * Get detector Rank.
     *
     * @return the rank value
     */
    public Double rank() {
        return this.rank;
    }

    /**
     * Get flag representing whether detector is enabled or not.
     *
     * @return the isEnabled value
     */
    public Boolean isEnabled() {
        return this.isEnabled;
    }

}