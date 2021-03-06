package com.billyang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**   
*    
* 项目名称：25-spring-boot-schedule   
* 类名称：App25   
* 类描述：   
* 创建人：yangcan14944   
* 创建时间：2018-10-11 上午9:28:51   
* 修改人：yangcan14944   
* 修改时间：2018-10-11 上午9:28:51   
* 修改备注：   
* @version    
*    
*/
@SpringBootApplication
@EnableScheduling
public class App25 {
	public static void main(String[] args) {
		SpringApplication.run(App25.class, args);
	}
}
