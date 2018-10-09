package com.billyang.exception;

import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

/**   
*    
* 项目名称：17-spring-boot-exception4   
* 类名称：GlobalException   
* 类描述：    springboot处理异常方式五通过实现 HandlerExceptionResolver 接口做全局异常处理
* 创建人：yangcan14944   
* 创建时间：2018-9-30 上午10:53:31   
* 修改人：yangcan14944   
* 修改时间：2018-9-30 上午10:53:31   
* 修改备注：   
* @version    
*    
*/
@Configuration
public class GlobalException implements HandlerExceptionResolver{

	@Override
	@Nullable
	public ModelAndView resolveException(HttpServletRequest request,HttpServletResponse response, @Nullable Object Handler, Exception ex) {
		ModelAndView mv = new ModelAndView();
		if(ex instanceof ArithmeticException){
			mv.setViewName("error1");
		}
		if(ex instanceof NullPointerException){
			mv.setViewName("error2");
		}
		mv.addObject("error",ex.toString());
		mv.addObject("aaaaaaaa");
		return mv;
	}
	
	
}
