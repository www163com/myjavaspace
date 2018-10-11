package com.billyang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**   
*    
* 项目名称：27-spring-boot-quartz   
* 类名称：App27   
* 类描述：   
* 创建人：yangcan14944   
* 创建时间：2018-10-11 上午10:30:02   
* 修改人：yangcan14944   
* 修改时间：2018-10-11 上午10:30:02   
* 修改备注：   
* @version    
*    
*/
@SpringBootApplication
@EnableScheduling
public class App27 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(App27.class, args);
	}
}
