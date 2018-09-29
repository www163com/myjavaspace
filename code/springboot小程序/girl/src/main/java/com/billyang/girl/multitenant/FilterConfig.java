package com.billyang.girl.multitenant;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class FilterConfig {
        @Bean
        public FilterRegistrationBean filterRegist() {
            FilterRegistrationBean frBean = new FilterRegistrationBean();
           frBean.setFilter(new MultiTenantFilter());
            frBean.setName("loginFilter");
            frBean.addUrlPatterns("/**");
            return frBean;
        }
}
