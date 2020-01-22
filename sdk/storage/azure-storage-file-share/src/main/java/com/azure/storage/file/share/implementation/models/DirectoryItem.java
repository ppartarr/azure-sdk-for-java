// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.storage.file.share.implementation.models;

import com.azure.core.annotation.Fluent;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

/**
 * A listed directory item.
 */
@JacksonXmlRootElement(localName = "Directory")
@Fluent
public final class DirectoryItem {
    /*
     * The name property.
     */
    @JsonProperty(value = "Name", required = true)
    private String name;

    /**
     * Get the name property: The name property.
     *
     * @return the name value.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Set the name property: The name property.
     *
     * @param name the name value to set.
     * @return the DirectoryItem object itself.
     */
    public DirectoryItem setName(String name) {
        this.name = name;
        return this;
    }
}