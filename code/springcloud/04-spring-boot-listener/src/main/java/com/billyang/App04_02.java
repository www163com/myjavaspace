package com.billyang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;

import com.billyang.listener.SecondListener;

/**
 * @author yangcan14944 SpringBoot整合Filter方式二
 */
/**
 * @author yangcan14944
 *
 */
@SpringBootApplication
public class App04_02 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(App04_02.class, args);
	}
	//注册listener
	@Bean
     public ServletListenerRegistrationBean<SecondListener> getServletListenerRegistrationBean(){
    	 ServletListenerRegistrationBean<SecondListener> bean = new ServletListenerRegistrationBean(new SecondListener());
    	 return bean;
     }
}
