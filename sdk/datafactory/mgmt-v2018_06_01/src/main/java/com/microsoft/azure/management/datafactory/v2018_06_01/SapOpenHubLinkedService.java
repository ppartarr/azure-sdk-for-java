/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.datafactory.v2018_06_01;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.microsoft.rest.serializer.JsonFlatten;
import com.microsoft.azure.management.datafactory.v2018_06_01.implementation.LinkedServiceInner;

/**
 * SAP Business Warehouse Open Hub Destination Linked Service.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type", defaultImpl = SapOpenHubLinkedService.class)
@JsonTypeName("SapOpenHub")
@JsonFlatten
public class SapOpenHubLinkedService extends LinkedServiceInner {
    /**
     * Host name of the SAP BW instance where the open hub destination is
     * located. Type: string (or Expression with resultType string).
     */
    @JsonProperty(value = "typeProperties.server")
    private Object server;

    /**
     * System number of the BW system where the open hub destination is
     * located. (Usually a two-digit decimal number represented as a string.)
     * Type: string (or Expression with resultType string).
     */
    @JsonProperty(value = "typeProperties.systemNumber")
    private Object systemNumber;

    /**
     * Client ID of the client on the BW system where the open hub destination
     * is located. (Usually a three-digit decimal number represented as a
     * string) Type: string (or Expression with resultType string).
     */
    @JsonProperty(value = "typeProperties.clientId")
    private Object clientId;

    /**
     * Language of the BW system where the open hub destination is located. The
     * default value is EN. Type: string (or Expression with resultType
     * string).
     */
    @JsonProperty(value = "typeProperties.language")
    private Object language;

    /**
     * SystemID of the SAP system where the table is located. Type: string (or
     * Expression with resultType string).
     */
    @JsonProperty(value = "typeProperties.systemId")
    private Object systemId;

    /**
     * Username to access the SAP BW server where the open hub destination is
     * located. Type: string (or Expression with resultType string).
     */
    @JsonProperty(value = "typeProperties.userName")
    private Object userName;

    /**
     * Password to access the SAP BW server where the open hub destination is
     * located.
     */
    @JsonProperty(value = "typeProperties.password")
    private SecretBase password;

    /**
     * The hostname of the SAP Message Server. Type: string (or Expression with
     * resultType string).
     */
    @JsonProperty(value = "typeProperties.messageServer")
    private Object messageServer;

    /**
     * The service name or port number of the Message Server. Type: string (or
     * Expression with resultType string).
     */
    @JsonProperty(value = "typeProperties.messageServerService")
    private Object messageServerService;

    /**
     * The Logon Group for the SAP System. Type: string (or Expression with
     * resultType string).
     */
    @JsonProperty(value = "typeProperties.logonGroup")
    private Object logonGroup;

    /**
     * The encrypted credential used for authentication. Credentials are
     * encrypted using the integration runtime credential manager. Type: string
     * (or Expression with resultType string).
     */
    @JsonProperty(value = "typeProperties.encryptedCredential")
    private Object encryptedCredential;

    /**
     * Get host name of the SAP BW instance where the open hub destination is located. Type: string (or Expression with resultType string).
     *
     * @return the server value
     */
    public Object server() {
        return this.server;
    }

    /**
     * Set host name of the SAP BW instance where the open hub destination is located. Type: string (or Expression with resultType string).
     *
     * @param server the server value to set
     * @return the SapOpenHubLinkedService object itself.
     */
    public SapOpenHubLinkedService withServer(Object server) {
        this.server = server;
        return this;
    }

    /**
     * Get system number of the BW system where the open hub destination is located. (Usually a two-digit decimal number represented as a string.) Type: string (or Expression with resultType string).
     *
     * @return the systemNumber value
     */
    public Object systemNumber() {
        return this.systemNumber;
    }

    /**
     * Set system number of the BW system where the open hub destination is located. (Usually a two-digit decimal number represented as a string.) Type: string (or Expression with resultType string).
     *
     * @param systemNumber the systemNumber value to set
     * @return the SapOpenHubLinkedService object itself.
     */
    public SapOpenHubLinkedService withSystemNumber(Object systemNumber) {
        this.systemNumber = systemNumber;
        return this;
    }

    /**
     * Get client ID of the client on the BW system where the open hub destination is located. (Usually a three-digit decimal number represented as a string) Type: string (or Expression with resultType string).
     *
     * @return the clientId value
     */
    public Object clientId() {
        return this.clientId;
    }

    /**
     * Set client ID of the client on the BW system where the open hub destination is located. (Usually a three-digit decimal number represented as a string) Type: string (or Expression with resultType string).
     *
     * @param clientId the clientId value to set
     * @return the SapOpenHubLinkedService object itself.
     */
    public SapOpenHubLinkedService withClientId(Object clientId) {
        this.clientId = clientId;
        return this;
    }

    /**
     * Get language of the BW system where the open hub destination is located. The default value is EN. Type: string (or Expression with resultType string).
     *
     * @return the language value
     */
    public Object language() {
        return this.language;
    }

    /**
     * Set language of the BW system where the open hub destination is located. The default value is EN. Type: string (or Expression with resultType string).
     *
     * @param language the language value to set
     * @return the SapOpenHubLinkedService object itself.
     */
    public SapOpenHubLinkedService withLanguage(Object language) {
        this.language = language;
        return this;
    }

    /**
     * Get systemID of the SAP system where the table is located. Type: string (or Expression with resultType string).
     *
     * @return the systemId value
     */
    public Object systemId() {
        return this.systemId;
    }

    /**
     * Set systemID of the SAP system where the table is located. Type: string (or Expression with resultType string).
     *
     * @param systemId the systemId value to set
     * @return the SapOpenHubLinkedService object itself.
     */
    public SapOpenHubLinkedService withSystemId(Object systemId) {
        this.systemId = systemId;
        return this;
    }

    /**
     * Get username to access the SAP BW server where the open hub destination is located. Type: string (or Expression with resultType string).
     *
     * @return the userName value
     */
    public Object userName() {
        return this.userName;
    }

    /**
     * Set username to access the SAP BW server where the open hub destination is located. Type: string (or Expression with resultType string).
     *
     * @param userName the userName value to set
     * @return the SapOpenHubLinkedService object itself.
     */
    public SapOpenHubLinkedService withUserName(Object userName) {
        this.userName = userName;
        return this;
    }

    /**
     * Get password to access the SAP BW server where the open hub destination is located.
     *
     * @return the password value
     */
    public SecretBase password() {
        return this.password;
    }

    /**
     * Set password to access the SAP BW server where the open hub destination is located.
     *
     * @param password the password value to set
     * @return the SapOpenHubLinkedService object itself.
     */
    public SapOpenHubLinkedService withPassword(SecretBase password) {
        this.password = password;
        return this;
    }

    /**
     * Get the hostname of the SAP Message Server. Type: string (or Expression with resultType string).
     *
     * @return the messageServer value
     */
    public Object messageServer() {
        return this.messageServer;
    }

    /**
     * Set the hostname of the SAP Message Server. Type: string (or Expression with resultType string).
     *
     * @param messageServer the messageServer value to set
     * @return the SapOpenHubLinkedService object itself.
     */
    public SapOpenHubLinkedService withMessageServer(Object messageServer) {
        this.messageServer = messageServer;
        return this;
    }

    /**
     * Get the service name or port number of the Message Server. Type: string (or Expression with resultType string).
     *
     * @return the messageServerService value
     */
    public Object messageServerService() {
        return this.messageServerService;
    }

    /**
     * Set the service name or port number of the Message Server. Type: string (or Expression with resultType string).
     *
     * @param messageServerService the messageServerService value to set
     * @return the SapOpenHubLinkedService object itself.
     */
    public SapOpenHubLinkedService withMessageServerService(Object messageServerService) {
        this.messageServerService = messageServerService;
        return this;
    }

    /**
     * Get the Logon Group for the SAP System. Type: string (or Expression with resultType string).
     *
     * @return the logonGroup value
     */
    public Object logonGroup() {
        return this.logonGroup;
    }

    /**
     * Set the Logon Group for the SAP System. Type: string (or Expression with resultType string).
     *
     * @param logonGroup the logonGroup value to set
     * @return the SapOpenHubLinkedService object itself.
     */
    public SapOpenHubLinkedService withLogonGroup(Object logonGroup) {
        this.logonGroup = logonGroup;
        return this;
    }

    /**
     * Get the encrypted credential used for authentication. Credentials are encrypted using the integration runtime credential manager. Type: string (or Expression with resultType string).
     *
     * @return the encryptedCredential value
     */
    public Object encryptedCredential() {
        return this.encryptedCredential;
    }

    /**
     * Set the encrypted credential used for authentication. Credentials are encrypted using the integration runtime credential manager. Type: string (or Expression with resultType string).
     *
     * @param encryptedCredential the encryptedCredential value to set
     * @return the SapOpenHubLinkedService object itself.
     */
    public SapOpenHubLinkedService withEncryptedCredential(Object encryptedCredential) {
        this.encryptedCredential = encryptedCredential;
        return this;
    }

}
