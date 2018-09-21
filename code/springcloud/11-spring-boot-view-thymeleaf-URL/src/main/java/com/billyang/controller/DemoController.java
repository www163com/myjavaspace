package com.billyang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**   
*    
* 项目名称：10-spring-boot-view-thymeleaf   
* 类名称：DemoController   
* 类描述：   springboot整合thymeleaf-URL
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
	@RequestMapping("/{page}")
	public String showInfo(@PathVariable String page,Integer id,String name) {
		System.out.println("ID"+id+","+"NAME"+name);
		return page;
	}
	@RequestMapping("/path/{id}/{page}")
	public String showInfo2(@PathVariable String page,@PathVariable Integer id,String name) {
		System.out.println("ID"+id+","+"NAME"+name);
		return page;
	}
}
