package com.billyang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * 
 * @author yangcan14944 SpringBoot整合Servlet方式一
 */
@SpringBootApplication
@ServletComponentScan //在springboot启动时 会扫描@WebServlet并且实例化
public class App02 {
	public static void main(String[] args) {
		SpringApplication.run(App02.class, args);
	}

}
