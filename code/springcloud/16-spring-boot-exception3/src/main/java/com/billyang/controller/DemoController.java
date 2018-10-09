package com.billyang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**   
*    
* 项目名称：14-spring-boot-exception1   
* 类名称：DemoController   
* 类描述：   springboot处理异常方式三@ControllerAdvice+@ExceptionHandler
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
}
