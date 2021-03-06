// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.ai.anomalydetector.models;

import com.azure.core.annotation.Fluent;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.OffsetDateTime;

/** The Point model. */
@Fluent
public final class Point {
    /*
     * Timestamp of a data point (ISO8601 format).
     */
    @JsonProperty(value = "timestamp", required = true)
    private OffsetDateTime timestamp;

    /*
     * The measurement of that point, should be float.
     */
    @JsonProperty(value = "value", required = true)
    private float value;

    /**
     * Get the timestamp property: Timestamp of a data point (ISO8601 format).
     *
     * @return the timestamp value.
     */
    public OffsetDateTime getTimestamp() {
        return this.timestamp;
    }

    /**
     * Set the timestamp property: Timestamp of a data point (ISO8601 format).
     *
     * @param timestamp the timestamp value to set.
     * @return the Point object itself.
     */
    public Point setTimestamp(OffsetDateTime timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    /**
     * Get the value property: The measurement of that point, should be float.
     *
     * @return the value value.
     */
    public float getValue() {
        return this.value;
    }

    /**
     * Set the value property: The measurement of that point, should be float.
     *
     * @param value the value value to set.
     * @return the Point object itself.
     */
    public Point setValue(float value) {
        this.value = value;
        return this;
    }
}
