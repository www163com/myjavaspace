package com.billyang.exception;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

/**   
*    
* 项目名称：17-spring-boot-exception4   
* 类名称：GlobalException   
* 类描述：    springboot处理异常方式四配置 SimpleMappingExceptionResolver 处理异常
* 创建人：yangcan14944   
* 创建时间：2018-9-30 上午10:53:31   
* 修改人：yangcan14944   
* 修改时间：2018-9-30 上午10:53:31   
* 修改备注：   
* @version    
*    
*/
@Configuration
public class GlobalException {
	
	
	/**
	 * 该方法返回值必须是SimpleMappingExceptionResolver
	 * @return
	 */
	@Bean
	public SimpleMappingExceptionResolver  getSimpleMappingExceptionResolver(){
		SimpleMappingExceptionResolver resolver = new SimpleMappingExceptionResolver();
		Properties mappings = new Properties();
		//参数1是异常的类型，必须是异常类型的全名
		//参数二 视图名称
		mappings.put("java.lang.ArithmeticException", "error1");
		mappings.put("java.lang.NullPointerException", "error2");
		//设置异常已视图映射信息
		resolver.setExceptionMappings(mappings);
		resolver.setExceptionAttribute("aaaaaaaa");
		return resolver;
	}
}
