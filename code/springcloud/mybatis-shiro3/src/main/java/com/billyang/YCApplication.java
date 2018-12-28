package com.billyang;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


//@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
/**   
*    
* 项目名称：mybatis-shiro3   
* 类名称：YCApplication   
* 类描述：   
* 创建人：yangcan14944   
* 创建时间：2018-11-15 下午12:00:46   
* 修改人：yangcan14944   
* 修改时间：2018-11-15 下午12:00:46   
* 修改备注：   
* @version    
*    
*/
@SpringBootApplication
@MapperScan("com.billyang.project.*.*.mapper")
public class YCApplication {
	public static void main(String[] args) {
		SpringApplication.run(YCApplication.class,args);
	}

}
