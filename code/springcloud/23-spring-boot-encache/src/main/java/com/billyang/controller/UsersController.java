package com.billyang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**   
*    
* 项目名称：22-spring-boot-encache   
* 类名称：UsersController   
* 类描述：   springboot整合ehcache
* 创建人：yangcan14944   
* 创建时间：2018-10-8 下午2:23:54   
* 修改人：yangcan14944   
* 修改时间：2018-10-8 下午2:23:54   
* 修改备注：   
* @version    
*    
*/
@Controller
public class UsersController {
	@RequestMapping("/show")
	public String showPage(){
		System.out.println("Show Page init");
		return "index";
	}
}
