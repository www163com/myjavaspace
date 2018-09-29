package com.billyang.girl.multitenant;

import com.billyang.girl.properties.GirlProperties;
import org.hibernate.context.spi.CurrentTenantIdentifierResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import static com.billyang.girl.multitenant.MultiTenantConstants.CURRENT_TENANT_IDENTIFIER;
import static com.billyang.girl.multitenant.MultiTenantConstants.DEFAULT_TENANT_ID;

@Component
public class TenantIdentifierResolver implements CurrentTenantIdentifierResolver{

    @Autowired
    private TenantProperties tenantProperties;
    @Override
    public String resolveCurrentTenantIdentifier() {
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        if(null!=requestAttributes){
            String tenantId = (String) requestAttributes.getAttribute(tenantProperties.getCurrentTenantIdentifier(),RequestAttributes.SCOPE_REQUEST);
            if (tenantId != null) {
                return tenantId;
            }
        }
        return tenantProperties.getDefaultTenantName();

    }

    @Override
    public boolean validateExistingCurrentSessions() {
        return true;
    }
    public void forceCurrentTenantIndetifier(String tenant) {
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        if (requestAttributes != null) {
            requestAttributes.setAttribute(tenantProperties.getCurrentTenantIdentifier(), tenant, RequestAttributes.SCOPE_REQUEST);
        }
    }
}
