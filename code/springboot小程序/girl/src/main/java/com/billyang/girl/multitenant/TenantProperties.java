package com.billyang.girl.multitenant;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "tenant")
public class TenantProperties
{
    private String defaultTenantName;
    private String currentTenantIdentifier;
    private String tenantKey;

    public String getDefaultTenantName() {
        return defaultTenantName;
    }

    public void setDefaultTenantName(String defaultTenantName) {
        this.defaultTenantName = defaultTenantName;
    }

    public String getCurrentTenantIdentifier() {
        return currentTenantIdentifier;
    }

    public void setCurrentTenantIdentifier(String currentTenantIdentifier) {
        this.currentTenantIdentifier = currentTenantIdentifier;
    }

    public String getTenantKey() {
        return tenantKey;
    }

    public void setTenantKey(String tenantKey) {
        this.tenantKey = tenantKey;
    }


}
