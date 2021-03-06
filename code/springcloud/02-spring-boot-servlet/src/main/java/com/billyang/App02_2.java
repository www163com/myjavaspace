package com.billyang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

import com.billyang.servlet.SecondServlet;

/**
 * 
 * @author yangcan14944 SpringBoot整合Servlet方式二
 */
@SpringBootApplication
public class App02_2 {
	public static void main(String[] args) {
		SpringApplication.run(App02_2.class, args);
	}

	@Bean
	public ServletRegistrationBean<?> getServletRegistrationBean() {
		ServletRegistrationBean<?> bean = new ServletRegistrationBean(new SecondServlet());
		bean.addUrlMappings("/second");
		return bean;
	}
}
