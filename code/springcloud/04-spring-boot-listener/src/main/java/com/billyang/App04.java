package com.billyang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * 
 * @author yangcan14944 SpringBoot����Servlet��ʽһ
 */
@SpringBootApplication
@ServletComponentScan //��springboot����ʱ ��ɨ��@WebFilter����ʵ����
public class App04 {
	public static void main(String[] args) {
		SpringApplication.run(App04.class, args);
	}

}