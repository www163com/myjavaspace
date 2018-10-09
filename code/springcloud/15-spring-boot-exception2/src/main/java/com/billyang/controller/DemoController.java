package com.billyang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**   
*    
* 项目名称：14-spring-boot-exception1   
* 类名称：DemoController   
* 类描述：   springboot处理异常方式二 ExceptionHandler
* 创建人：yangcan14944   
* 创建时间：2018-9-30 上午9:56:54   
* 修改人：yangcan14944   
* 修改时间：2018-9-30 上午9:56:54   
* 修改备注：   
* @version    
*    
*/
@Controller
public class DemoController {
	@RequestMapping("/show")
	public String showInfo() {
		String str = null;
		str.length();
		return "index";
	}
	@RequestMapping("/show2")
	public String showInfo2() {
		int a = 10/0;
		return "index";
	}
	
	
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
