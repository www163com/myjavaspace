package com.billyang.girl.multitenant;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

import static com.billyang.girl.multitenant.MultiTenantConstants.CURRENT_TENANT_IDENTIFIER;
import static com.billyang.girl.multitenant.MultiTenantConstants.DEFAULT_TENANT_ID;
import static com.billyang.girl.multitenant.MultiTenantConstants.TENANT_KEY;
@Component
@WebFilter(urlPatterns = "/*",filterName = "loginFilter")
public class MultiTenantFilter  implements Filter{


    @Override
    public void init(javax.servlet.FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        if (req.getHeader(TENANT_KEY) != null) {
            req.setAttribute(CURRENT_TENANT_IDENTIFIER, req.getHeader(TENANT_KEY));
        } else {
            req.setAttribute(CURRENT_TENANT_IDENTIFIER, DEFAULT_TENANT_ID);
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
