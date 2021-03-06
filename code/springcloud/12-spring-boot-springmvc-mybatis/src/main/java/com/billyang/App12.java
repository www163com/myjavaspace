package com.billyang;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**   
*    
* 项目名称：12-spring-boot-springmvc-mybatis   
* 类名称：App12   
* 类描述：   启动类
* 创建人：yangcan14944   
* 创建时间：2018-9-26 下午2:19:37   
* 修改人：yangcan14944   
* 修改时间：2018-9-26 下午2:19:37   
* 修改备注：   
* @version    
*    
*/
@SpringBootApplication
@MapperScan("com.billyang.mapper") //@MapperScan 表示springboot在整合mybatis扫描mapper接口 然后生成代理对象
public class App12 {
	public static void main(String[] args) {
		SpringApplication.run(App12.class,args);
	}
}
