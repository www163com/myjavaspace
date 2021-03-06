package com.billyang.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * @author yangcan14944 Springboot 整合Filter方式一 <filter>
 *         <filter-name>FirstFilter</filter-name>
 *         <fliter-class>com.billyang.filter.FirstFilter</filter-class>
 *         </filter> <filter-mapping> <filter-name>FirstFilter<filter-name>
 *         <url-pattern>/hello</url-pattern> </filter-mapping>
 */
//@WebFilter(filterName="FirstFilter",urlPatterns={"*.do","*.jsp"})
@WebFilter(filterName="FirstFilter",urlPatterns="/first")
public class FirstFilter implements Filter {

	@Override
	public void destroy() {
		System.out.println("first filter destory");
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		System.out.println("进入 firstFilter");
		arg2.doFilter(arg0, arg1);
		System.out.println("离开firstFilter");
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("first filter init");
	}

}
