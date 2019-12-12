/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.peering.v2019_08_01_preview;

import java.util.Collection;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.microsoft.rest.ExpandableStringEnum;

/**
 * Defines values for ValidationState.
 */
public final class ValidationState extends ExpandableStringEnum<ValidationState> {
    /** Static value None for ValidationState. */
    public static final ValidationState NONE = fromString("None");

    /** Static value Pending for ValidationState. */
    public static final ValidationState PENDING = fromString("Pending");

    /** Static value Approved for ValidationState. */
    public static final ValidationState APPROVED = fromString("Approved");

    /** Static value Failed for ValidationState. */
    public static final ValidationState FAILED = fromString("Failed");

    /**
     * Creates or finds a ValidationState from its string representation.
     * @param name a name to look for
     * @return the corresponding ValidationState
     */
    @JsonCreator
    public static ValidationState fromString(String name) {
        return fromString(name, ValidationState.class);
    }

    /**
     * @return known ValidationState values
     */
    public static Collection<ValidationState> values() {
        return values(ValidationState.class);
    }
}