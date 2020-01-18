/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.mediaservices.v2018_07_01;

import java.util.Collection;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.microsoft.rest.ExpandableStringEnum;

/**
 * Defines values for TrackPropertyType.
 */
public final class TrackPropertyType extends ExpandableStringEnum<TrackPropertyType> {
    /** Static value Unknown for TrackPropertyType. */
    public static final TrackPropertyType UNKNOWN = fromString("Unknown");

    /** Static value FourCC for TrackPropertyType. */
    public static final TrackPropertyType FOUR_CC = fromString("FourCC");

    /**
     * Creates or finds a TrackPropertyType from its string representation.
     * @param name a name to look for
     * @return the corresponding TrackPropertyType
     */
    @JsonCreator
    public static TrackPropertyType fromString(String name) {
        return fromString(name, TrackPropertyType.class);
    }

    /**
     * @return known TrackPropertyType values
     */
    public static Collection<TrackPropertyType> values() {
        return values(TrackPropertyType.class);
    }
}