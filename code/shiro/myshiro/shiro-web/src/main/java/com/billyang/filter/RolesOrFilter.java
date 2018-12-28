package com.billyang.filter;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authz.AuthorizationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * @author yangcan14944
 * @version V1.0
 * @Project myshiro
 * @Package com.billyang.filter
 * @Description: ${todo}
 * @date 2018.12.28
 * @time 10:59
 */
public class RolesOrFilter extends AuthorizationFilter{
    protected boolean isAccessAllowed(ServletRequest servletRequest, ServletResponse servletResponse, Object o) throws Exception {
        Subject subject = getSubject(servletRequest,servletResponse);
        String[] roles = (String[]) o;
        if(null==roles || roles.length==0){
            return true;
        }
        for(String role:roles){
            if(subject.hasRole(role)){
                return true;
            }
        }
        return false;
    }
}
