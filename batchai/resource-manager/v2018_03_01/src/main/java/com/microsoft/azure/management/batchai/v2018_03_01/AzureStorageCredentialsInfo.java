/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.batchai.v2018_03_01;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Credentials to access Azure File Share.
 */
public class AzureStorageCredentialsInfo {
    /**
     * Storage account key.
     * One of accountKey or accountKeySecretReference must be specified.
     */
    @JsonProperty(value = "accountKey")
    private String accountKey;

    /**
     * Specifies the location of the storage account key, which is a Key Vault
     * Secret.
     * Users can store their secrets in Azure KeyVault and pass it to the Batch
     * AI Service to integrate with KeyVault. One of accountKey or
     * accountKeySecretReference must be specified.
     */
    @JsonProperty(value = "accountKeySecretReference")
    private KeyVaultSecretReference accountKeySecretReference;

    /**
     * Get one of accountKey or accountKeySecretReference must be specified.
     *
     * @return the accountKey value
     */
    public String accountKey() {
        return this.accountKey;
    }

    /**
     * Set one of accountKey or accountKeySecretReference must be specified.
     *
     * @param accountKey the accountKey value to set
     * @return the AzureStorageCredentialsInfo object itself.
     */
    public AzureStorageCredentialsInfo withAccountKey(String accountKey) {
        this.accountKey = accountKey;
        return this;
    }

    /**
     * Get users can store their secrets in Azure KeyVault and pass it to the Batch AI Service to integrate with KeyVault. One of accountKey or accountKeySecretReference must be specified.
     *
     * @return the accountKeySecretReference value
     */
    public KeyVaultSecretReference accountKeySecretReference() {
        return this.accountKeySecretReference;
    }

    /**
     * Set users can store their secrets in Azure KeyVault and pass it to the Batch AI Service to integrate with KeyVault. One of accountKey or accountKeySecretReference must be specified.
     *
     * @param accountKeySecretReference the accountKeySecretReference value to set
     * @return the AzureStorageCredentialsInfo object itself.
     */
    public AzureStorageCredentialsInfo withAccountKeySecretReference(KeyVaultSecretReference accountKeySecretReference) {
        this.accountKeySecretReference = accountKeySecretReference;
        return this;
    }

}