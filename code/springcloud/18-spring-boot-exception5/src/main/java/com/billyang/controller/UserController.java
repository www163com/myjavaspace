package com.billyang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**   
*    
* 项目名称：17-spring-boot-exception4     
* 类名称：DemoController   
* 类描述：   springboot处理异常方式五通过实现 HandlerExceptionResolver 接口做全局异常处理
* 创建人：yangcan14944   
* 创建时间：2018-9-30 上午9:56:54   
* 修改人：yangcan14944   
* 修改时间：2018-9-30 上午9:56:54   
* 修改备注：   
* @version    
*    
*/
@Controller
public class UserController {
	@RequestMapping("/showUser")
	public String showInfo() {
		String str = null;
		str.length();
		return "index";
	}
	@RequestMapping("/showUser2")
	public String showInfo2() {
		int a = 10/0;
		return "index";
	}
}
