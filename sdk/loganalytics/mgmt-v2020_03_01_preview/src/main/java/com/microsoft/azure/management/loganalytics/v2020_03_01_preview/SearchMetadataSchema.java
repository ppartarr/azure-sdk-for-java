/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.loganalytics.v2020_03_01_preview;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Schema metadata for search.
 */
public class SearchMetadataSchema {
    /**
     * The name of the metadata schema.
     */
    @JsonProperty(value = "name")
    private String name;

    /**
     * The version of the metadata schema.
     */
    @JsonProperty(value = "version")
    private Integer version;

    /**
     * Get the name of the metadata schema.
     *
     * @return the name value
     */
    public String name() {
        return this.name;
    }

    /**
     * Set the name of the metadata schema.
     *
     * @param name the name value to set
     * @return the SearchMetadataSchema object itself.
     */
    public SearchMetadataSchema withName(String name) {
        this.name = name;
        return this;
    }

    /**
     * Get the version of the metadata schema.
     *
     * @return the version value
     */
    public Integer version() {
        return this.version;
    }

    /**
     * Set the version of the metadata schema.
     *
     * @param version the version value to set
     * @return the SearchMetadataSchema object itself.
     */
    public SearchMetadataSchema withVersion(Integer version) {
        this.version = version;
        return this;
    }

}
