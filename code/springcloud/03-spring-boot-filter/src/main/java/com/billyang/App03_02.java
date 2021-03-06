package com.billyang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

import com.billyang.filter.SecondFilter;
import com.billyang.servlet.SecondServlet;

/**
 * @author yangcan14944 SpringBoot整合Filter方式二
 */
/**
 * @author yangcan14944
 *
 */
@SpringBootApplication
public class App03_02 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(App03_02.class, args);
	}
	/**
	 * 注册servlet
	 * @return
	 */
	@Bean
	public ServletRegistrationBean<?> getServletRegistrationBean() {
		ServletRegistrationBean<?> bean = new ServletRegistrationBean(new SecondServlet());
		bean.addUrlMappings("/second");
		return bean;
	}
	/*
	 * 注册Filter
	 * 
	 * */
	@Bean
	public FilterRegistrationBean getFilterRegistrationBean(){
		FilterRegistrationBean bean = new FilterRegistrationBean(new SecondFilter());
		//bean.addUrlPatterns(new String[]{"*.do,*.jsp"});
		bean.addUrlPatterns("/second");
		return bean;
	}
}
