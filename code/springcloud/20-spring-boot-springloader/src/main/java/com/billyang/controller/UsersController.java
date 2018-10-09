package com.billyang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**   
*    
* 项目名称：20-spring-boot-springloader   
* 类名称：UsersController   
* 类描述：   sptingboot整合springloader
* 创建人：yangcan14944   
* 创建时间：2018-10-8 上午10:53:37   
* 修改人：yangcan14944   
* 修改时间：2018-10-8 上午10:53:37   
* 修改备注：   
* @version    
*    
*/
@Controller
public class UsersController {
	@RequestMapping("/show")
	public String showPage(){
		System.out.println("Show Page aaainit11111....aa");
		return "index";
	}
}
