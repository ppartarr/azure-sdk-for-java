/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.network.v2020_06_01.implementation;

import java.util.List;
import com.microsoft.azure.management.network.v2020_06_01.VirtualNetworkGatewayIPConfiguration;
import com.microsoft.azure.management.network.v2020_06_01.VirtualNetworkGatewayType;
import com.microsoft.azure.management.network.v2020_06_01.VpnType;
import com.microsoft.azure.management.network.v2020_06_01.VpnGatewayGeneration;
import com.microsoft.azure.SubResource;
import com.microsoft.azure.management.network.v2020_06_01.VirtualNetworkGatewaySku;
import com.microsoft.azure.management.network.v2020_06_01.VpnClientConfiguration;
import com.microsoft.azure.management.network.v2020_06_01.BgpSettings;
import com.microsoft.azure.management.network.v2020_06_01.AddressSpace;
import com.microsoft.azure.management.network.v2020_06_01.ProvisioningState;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.microsoft.rest.serializer.JsonFlatten;
import com.microsoft.rest.SkipParentValidation;
import com.microsoft.azure.Resource;

/**
 * A common class for general resource information.
 */
@JsonFlatten
@SkipParentValidation
public class VirtualNetworkGatewayInner extends Resource {
    /**
     * IP configurations for virtual network gateway.
     */
    @JsonProperty(value = "properties.ipConfigurations")
    private List<VirtualNetworkGatewayIPConfiguration> ipConfigurations;

    /**
     * The type of this virtual network gateway. Possible values include:
     * 'Vpn', 'ExpressRoute'.
     */
    @JsonProperty(value = "properties.gatewayType")
    private VirtualNetworkGatewayType gatewayType;

    /**
     * The type of this virtual network gateway. Possible values include:
     * 'PolicyBased', 'RouteBased'.
     */
    @JsonProperty(value = "properties.vpnType")
    private VpnType vpnType;

    /**
     * The generation for this VirtualNetworkGateway. Must be None if
     * gatewayType is not VPN. Possible values include: 'None', 'Generation1',
     * 'Generation2'.
     */
    @JsonProperty(value = "properties.vpnGatewayGeneration")
    private VpnGatewayGeneration vpnGatewayGeneration;

    /**
     * Whether BGP is enabled for this virtual network gateway or not.
     */
    @JsonProperty(value = "properties.enableBgp")
    private Boolean enableBgp;

    /**
     * Whether private IP needs to be enabled on this gateway for connections
     * or not.
     */
    @JsonProperty(value = "properties.enablePrivateIpAddress")
    private Boolean enablePrivateIpAddress;

    /**
     * ActiveActive flag.
     */
    @JsonProperty(value = "properties.activeActive")
    private Boolean activeActive;

    /**
     * The reference to the LocalNetworkGateway resource which represents local
     * network site having default routes. Assign Null value in case of
     * removing existing default site setting.
     */
    @JsonProperty(value = "properties.gatewayDefaultSite")
    private SubResource gatewayDefaultSite;

    /**
     * The reference to the VirtualNetworkGatewaySku resource which represents
     * the SKU selected for Virtual network gateway.
     */
    @JsonProperty(value = "properties.sku")
    private VirtualNetworkGatewaySku sku;

    /**
     * The reference to the VpnClientConfiguration resource which represents
     * the P2S VpnClient configurations.
     */
    @JsonProperty(value = "properties.vpnClientConfiguration")
    private VpnClientConfiguration vpnClientConfiguration;

    /**
     * Virtual network gateway's BGP speaker settings.
     */
    @JsonProperty(value = "properties.bgpSettings")
    private BgpSettings bgpSettings;

    /**
     * The reference to the address space resource which represents the custom
     * routes address space specified by the customer for virtual network
     * gateway and VpnClient.
     */
    @JsonProperty(value = "properties.customRoutes")
    private AddressSpace customRoutes;

    /**
     * The resource GUID property of the virtual network gateway resource.
     */
    @JsonProperty(value = "properties.resourceGuid", access = JsonProperty.Access.WRITE_ONLY)
    private String resourceGuid;

    /**
     * The provisioning state of the virtual network gateway resource. Possible
     * values include: 'Succeeded', 'Updating', 'Deleting', 'Failed'.
     */
    @JsonProperty(value = "properties.provisioningState", access = JsonProperty.Access.WRITE_ONLY)
    private ProvisioningState provisioningState;

    /**
     * Whether dns forwarding is enabled or not.
     */
    @JsonProperty(value = "properties.enableDnsForwarding")
    private Boolean enableDnsForwarding;

    /**
     * The IP address allocated by the gateway to which dns requests can be
     * sent.
     */
    @JsonProperty(value = "properties.inboundDnsForwardingEndpoint", access = JsonProperty.Access.WRITE_ONLY)
    private String inboundDnsForwardingEndpoint;

    /**
     * A unique read-only string that changes whenever the resource is updated.
     */
    @JsonProperty(value = "etag", access = JsonProperty.Access.WRITE_ONLY)
    private String etag;

    /**
     * Resource ID.
     */
    @JsonProperty(value = "id")
    private String id;

    /**
     * Get iP configurations for virtual network gateway.
     *
     * @return the ipConfigurations value
     */
    public List<VirtualNetworkGatewayIPConfiguration> ipConfigurations() {
        return this.ipConfigurations;
    }

    /**
     * Set iP configurations for virtual network gateway.
     *
     * @param ipConfigurations the ipConfigurations value to set
     * @return the VirtualNetworkGatewayInner object itself.
     */
    public VirtualNetworkGatewayInner withIpConfigurations(List<VirtualNetworkGatewayIPConfiguration> ipConfigurations) {
        this.ipConfigurations = ipConfigurations;
        return this;
    }

    /**
     * Get the type of this virtual network gateway. Possible values include: 'Vpn', 'ExpressRoute'.
     *
     * @return the gatewayType value
     */
    public VirtualNetworkGatewayType gatewayType() {
        return this.gatewayType;
    }

    /**
     * Set the type of this virtual network gateway. Possible values include: 'Vpn', 'ExpressRoute'.
     *
     * @param gatewayType the gatewayType value to set
     * @return the VirtualNetworkGatewayInner object itself.
     */
    public VirtualNetworkGatewayInner withGatewayType(VirtualNetworkGatewayType gatewayType) {
        this.gatewayType = gatewayType;
        return this;
    }

    /**
     * Get the type of this virtual network gateway. Possible values include: 'PolicyBased', 'RouteBased'.
     *
     * @return the vpnType value
     */
    public VpnType vpnType() {
        return this.vpnType;
    }

    /**
     * Set the type of this virtual network gateway. Possible values include: 'PolicyBased', 'RouteBased'.
     *
     * @param vpnType the vpnType value to set
     * @return the VirtualNetworkGatewayInner object itself.
     */
    public VirtualNetworkGatewayInner withVpnType(VpnType vpnType) {
        this.vpnType = vpnType;
        return this;
    }

    /**
     * Get the generation for this VirtualNetworkGateway. Must be None if gatewayType is not VPN. Possible values include: 'None', 'Generation1', 'Generation2'.
     *
     * @return the vpnGatewayGeneration value
     */
    public VpnGatewayGeneration vpnGatewayGeneration() {
        return this.vpnGatewayGeneration;
    }

    /**
     * Set the generation for this VirtualNetworkGateway. Must be None if gatewayType is not VPN. Possible values include: 'None', 'Generation1', 'Generation2'.
     *
     * @param vpnGatewayGeneration the vpnGatewayGeneration value to set
     * @return the VirtualNetworkGatewayInner object itself.
     */
    public VirtualNetworkGatewayInner withVpnGatewayGeneration(VpnGatewayGeneration vpnGatewayGeneration) {
        this.vpnGatewayGeneration = vpnGatewayGeneration;
        return this;
    }

    /**
     * Get whether BGP is enabled for this virtual network gateway or not.
     *
     * @return the enableBgp value
     */
    public Boolean enableBgp() {
        return this.enableBgp;
    }

    /**
     * Set whether BGP is enabled for this virtual network gateway or not.
     *
     * @param enableBgp the enableBgp value to set
     * @return the VirtualNetworkGatewayInner object itself.
     */
    public VirtualNetworkGatewayInner withEnableBgp(Boolean enableBgp) {
        this.enableBgp = enableBgp;
        return this;
    }

    /**
     * Get whether private IP needs to be enabled on this gateway for connections or not.
     *
     * @return the enablePrivateIpAddress value
     */
    public Boolean enablePrivateIpAddress() {
        return this.enablePrivateIpAddress;
    }

    /**
     * Set whether private IP needs to be enabled on this gateway for connections or not.
     *
     * @param enablePrivateIpAddress the enablePrivateIpAddress value to set
     * @return the VirtualNetworkGatewayInner object itself.
     */
    public VirtualNetworkGatewayInner withEnablePrivateIpAddress(Boolean enablePrivateIpAddress) {
        this.enablePrivateIpAddress = enablePrivateIpAddress;
        return this;
    }

    /**
     * Get activeActive flag.
     *
     * @return the activeActive value
     */
    public Boolean activeActive() {
        return this.activeActive;
    }

    /**
     * Set activeActive flag.
     *
     * @param activeActive the activeActive value to set
     * @return the VirtualNetworkGatewayInner object itself.
     */
    public VirtualNetworkGatewayInner withActiveActive(Boolean activeActive) {
        this.activeActive = activeActive;
        return this;
    }

    /**
     * Get the reference to the LocalNetworkGateway resource which represents local network site having default routes. Assign Null value in case of removing existing default site setting.
     *
     * @return the gatewayDefaultSite value
     */
    public SubResource gatewayDefaultSite() {
        return this.gatewayDefaultSite;
    }

    /**
     * Set the reference to the LocalNetworkGateway resource which represents local network site having default routes. Assign Null value in case of removing existing default site setting.
     *
     * @param gatewayDefaultSite the gatewayDefaultSite value to set
     * @return the VirtualNetworkGatewayInner object itself.
     */
    public VirtualNetworkGatewayInner withGatewayDefaultSite(SubResource gatewayDefaultSite) {
        this.gatewayDefaultSite = gatewayDefaultSite;
        return this;
    }

    /**
     * Get the reference to the VirtualNetworkGatewaySku resource which represents the SKU selected for Virtual network gateway.
     *
     * @return the sku value
     */
    public VirtualNetworkGatewaySku sku() {
        return this.sku;
    }

    /**
     * Set the reference to the VirtualNetworkGatewaySku resource which represents the SKU selected for Virtual network gateway.
     *
     * @param sku the sku value to set
     * @return the VirtualNetworkGatewayInner object itself.
     */
    public VirtualNetworkGatewayInner withSku(VirtualNetworkGatewaySku sku) {
        this.sku = sku;
        return this;
    }

    /**
     * Get the reference to the VpnClientConfiguration resource which represents the P2S VpnClient configurations.
     *
     * @return the vpnClientConfiguration value
     */
    public VpnClientConfiguration vpnClientConfiguration() {
        return this.vpnClientConfiguration;
    }

    /**
     * Set the reference to the VpnClientConfiguration resource which represents the P2S VpnClient configurations.
     *
     * @param vpnClientConfiguration the vpnClientConfiguration value to set
     * @return the VirtualNetworkGatewayInner object itself.
     */
    public VirtualNetworkGatewayInner withVpnClientConfiguration(VpnClientConfiguration vpnClientConfiguration) {
        this.vpnClientConfiguration = vpnClientConfiguration;
        return this;
    }

    /**
     * Get virtual network gateway's BGP speaker settings.
     *
     * @return the bgpSettings value
     */
    public BgpSettings bgpSettings() {
        return this.bgpSettings;
    }

    /**
     * Set virtual network gateway's BGP speaker settings.
     *
     * @param bgpSettings the bgpSettings value to set
     * @return the VirtualNetworkGatewayInner object itself.
     */
    public VirtualNetworkGatewayInner withBgpSettings(BgpSettings bgpSettings) {
        this.bgpSettings = bgpSettings;
        return this;
    }

    /**
     * Get the reference to the address space resource which represents the custom routes address space specified by the customer for virtual network gateway and VpnClient.
     *
     * @return the customRoutes value
     */
    public AddressSpace customRoutes() {
        return this.customRoutes;
    }

    /**
     * Set the reference to the address space resource which represents the custom routes address space specified by the customer for virtual network gateway and VpnClient.
     *
     * @param customRoutes the customRoutes value to set
     * @return the VirtualNetworkGatewayInner object itself.
     */
    public VirtualNetworkGatewayInner withCustomRoutes(AddressSpace customRoutes) {
        this.customRoutes = customRoutes;
        return this;
    }

    /**
     * Get the resource GUID property of the virtual network gateway resource.
     *
     * @return the resourceGuid value
     */
    public String resourceGuid() {
        return this.resourceGuid;
    }

    /**
     * Get the provisioning state of the virtual network gateway resource. Possible values include: 'Succeeded', 'Updating', 'Deleting', 'Failed'.
     *
     * @return the provisioningState value
     */
    public ProvisioningState provisioningState() {
        return this.provisioningState;
    }

    /**
     * Get whether dns forwarding is enabled or not.
     *
     * @return the enableDnsForwarding value
     */
    public Boolean enableDnsForwarding() {
        return this.enableDnsForwarding;
    }

    /**
     * Set whether dns forwarding is enabled or not.
     *
     * @param enableDnsForwarding the enableDnsForwarding value to set
     * @return the VirtualNetworkGatewayInner object itself.
     */
    public VirtualNetworkGatewayInner withEnableDnsForwarding(Boolean enableDnsForwarding) {
        this.enableDnsForwarding = enableDnsForwarding;
        return this;
    }

    /**
     * Get the IP address allocated by the gateway to which dns requests can be sent.
     *
     * @return the inboundDnsForwardingEndpoint value
     */
    public String inboundDnsForwardingEndpoint() {
        return this.inboundDnsForwardingEndpoint;
    }

    /**
     * Get a unique read-only string that changes whenever the resource is updated.
     *
     * @return the etag value
     */
    public String etag() {
        return this.etag;
    }

    /**
     * Get resource ID.
     *
     * @return the id value
     */
    public String id() {
        return this.id;
    }

    /**
     * Set resource ID.
     *
     * @param id the id value to set
     * @return the VirtualNetworkGatewayInner object itself.
     */
    public VirtualNetworkGatewayInner withId(String id) {
        this.id = id;
        return this;
    }

}
