package com.billyang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.billyang.pojo.Users;

/**   
*    
* 项目名称：13-spring-boot-springmvc-validate   
* 类名称：UsersController   
* 类描述：   服务端校验
* 创建人：yangcan14944   
* 创建时间：2018-9-29 下午2:52:43   
* 修改人：yangcan14944   
* 修改时间：2018-9-29 下午2:52:43   
* 修改备注：   
* @version    
*    
*/
@Controller
public class UsersController {
	@RequestMapping("/addUser")
	public String showPage(){
		return "add";
	}
	//完成用户添加
	@RequestMapping("/save")
	public  String saveUser(Users user){
		System.out.println(user);
		return "ok";
	}
}
