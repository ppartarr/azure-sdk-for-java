// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
package com.azure.cosmos.implementation.changefeed;

import com.azure.cosmos.CosmosAsyncItem;
import com.azure.cosmos.CosmosItemRequestOptions;
import reactor.core.publisher.Mono;

import java.util.function.Function;

/**
 * Interface for service lease updater.
 */
public interface ServiceItemLeaseUpdater {
    Mono<Lease> updateLease(Lease cachedLease, CosmosAsyncItem itemLink, CosmosItemRequestOptions requestOptions, Function<Lease, Lease> updateLease);
}