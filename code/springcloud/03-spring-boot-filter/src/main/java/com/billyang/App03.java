package com.billyang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * 
 * @author yangcan14944 SpringBoot整合Servlet方式一
 */
@SpringBootApplication
@ServletComponentScan //在springboot启动时 会扫描@WebFilter并且实例化
public class App03 {
	public static void main(String[] args) {
		SpringApplication.run(App03.class, args);
	}

}
