/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.redis.v2018_03_01.implementation;

import com.microsoft.azure.management.redis.v2018_03_01.RedisFirewallRule;
import com.microsoft.azure.arm.model.implementation.CreatableUpdatableImpl;
import rx.Observable;
import com.microsoft.azure.management.redis.v2018_03_01.RedisFirewallRuleCreateParameters;
import rx.functions.Func1;

class RedisFirewallRuleImpl extends CreatableUpdatableImpl<RedisFirewallRule, RedisFirewallRuleInner, RedisFirewallRuleImpl> implements RedisFirewallRule, RedisFirewallRule.Definition, RedisFirewallRule.Update {
    private final RedisManager manager;
    private String resourceGroupName;
    private String cacheName;
    private String ruleName;
    private RedisFirewallRuleCreateParameters createOrUpdateParameter;

    RedisFirewallRuleImpl(String name, RedisManager manager) {
        super(name, new RedisFirewallRuleInner());
        this.manager = manager;
        // Set resource name
        this.ruleName = name;
        //
        this.createOrUpdateParameter = new RedisFirewallRuleCreateParameters();
    }

    RedisFirewallRuleImpl(RedisFirewallRuleInner inner, RedisManager manager) {
        super(inner.name(), inner);
        this.manager = manager;
        // Set resource name
        this.ruleName = inner.name();
        // set resource ancestor and positional variables
        this.resourceGroupName = IdParsingUtils.getValueFromIdByName(inner.id(), "resourceGroups");
        this.cacheName = IdParsingUtils.getValueFromIdByName(inner.id(), "Redis");
        this.ruleName = IdParsingUtils.getValueFromIdByName(inner.id(), "firewallRules");
        //
        this.createOrUpdateParameter = new RedisFirewallRuleCreateParameters();
    }

    @Override
    public RedisManager manager() {
        return this.manager;
    }

    @Override
    public Observable<RedisFirewallRule> createResourceAsync() {
        FirewallRulesInner client = this.manager().inner().firewallRules();
        return client.createOrUpdateAsync(this.resourceGroupName, this.cacheName, this.ruleName, this.createOrUpdateParameter)
            .map(new Func1<RedisFirewallRuleInner, RedisFirewallRuleInner>() {
               @Override
               public RedisFirewallRuleInner call(RedisFirewallRuleInner resource) {
                   resetCreateUpdateParameters();
                   return resource;
               }
            })
            .map(innerToFluentMap(this));
    }

    @Override
    public Observable<RedisFirewallRule> updateResourceAsync() {
        FirewallRulesInner client = this.manager().inner().firewallRules();
        return client.createOrUpdateAsync(this.resourceGroupName, this.cacheName, this.ruleName, this.createOrUpdateParameter)
            .map(new Func1<RedisFirewallRuleInner, RedisFirewallRuleInner>() {
               @Override
               public RedisFirewallRuleInner call(RedisFirewallRuleInner resource) {
                   resetCreateUpdateParameters();
                   return resource;
               }
            })
            .map(innerToFluentMap(this));
    }

    @Override
    protected Observable<RedisFirewallRuleInner> getInnerAsync() {
        FirewallRulesInner client = this.manager().inner().firewallRules();
        return client.getAsync(this.resourceGroupName, this.cacheName, this.ruleName);
    }

    @Override
    public boolean isInCreateMode() {
        return this.inner().id() == null;
    }

    private void resetCreateUpdateParameters() {
        this.createOrUpdateParameter = new RedisFirewallRuleCreateParameters();
    }

    @Override
    public String endIP() {
        return this.inner().endIP();
    }

    @Override
    public String id() {
        return this.inner().id();
    }

    @Override
    public String name() {
        return this.inner().name();
    }

    @Override
    public String startIP() {
        return this.inner().startIP();
    }

    @Override
    public String type() {
        return this.inner().type();
    }

    @Override
    public RedisFirewallRuleImpl withExistingRedis(String resourceGroupName, String cacheName) {
        this.resourceGroupName = resourceGroupName;
        this.cacheName = cacheName;
        return this;
    }

    @Override
    public RedisFirewallRuleImpl withEndIP(String endIP) {
        this.createOrUpdateParameter.withEndIP(endIP);
        return this;
    }

    @Override
    public RedisFirewallRuleImpl withStartIP(String startIP) {
        this.createOrUpdateParameter.withStartIP(startIP);
        return this;
    }

}