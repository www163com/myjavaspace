package com.billyang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**   
*    
* 项目名称：10-spring-boot-view-thymeleaf   
* 类名称：DemoController   
* 类描述：   springboot整合thymeleaf
* 创建人：yangcan14944   
* 创建时间：2018-9-19 上午10:58:32   
* 修改人：yangcan14944   
* 修改时间：2018-9-19 上午10:58:32   
* 修改备注：   
* @version    
*    
*/
@Controller
public class DemoController {
	@RequestMapping("/show")
	public String showInfo(Model model) {
		model.addAttribute("msg", "Thymeleaf第一条案例");
		return "index";
	}
}
