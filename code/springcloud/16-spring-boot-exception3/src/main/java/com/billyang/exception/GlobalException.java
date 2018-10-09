package com.billyang.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**   
*    
* 项目名称：16-spring-boot-exception3   
* 类名称：GlobalException   
* 类描述：    springboot处理异常方式三@ControllerAdvice+@ExceptionHandler
* 创建人：yangcan14944   
* 创建时间：2018-9-30 上午10:53:31   
* 修改人：yangcan14944   
* 修改时间：2018-9-30 上午10:53:31   
* 修改备注：   
* @version    
*    
*/
@ControllerAdvice
public class GlobalException {
	//java.lang.ArithmeticException
		//该方法需要返回一个modelAndView目的是可以让我们封装异常信息以及视图的指定 
		//参数Exception e 会将产生的异常对象注入到方法中
		@ExceptionHandler(value={java.lang.ArithmeticException.class})
		public ModelAndView arithmeticExceptionExceptionHandler(Exception e){
			ModelAndView mv = new ModelAndView();
			mv.addObject("error", e.toString());
			mv.setViewName("error2");
			return mv;
		}
		
		//java.lang.NullPointerException
		@ExceptionHandler(value={java.lang.NullPointerException.class})
		public ModelAndView nullPointerExceptionHandler(Exception e){
			ModelAndView mv = new ModelAndView();
			mv.addObject("error", e.toString());
			mv.setViewName("error1");
			return mv;
		}

}
