package com.billyang.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
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
	public String showPage(Users users){
		return "add";
	}
	//完成用户添加
	/**
	 * @param user
	 * @param result
	 * @return
	 * BindingResult 封装了校验的结果
	 */
	@RequestMapping("/save")
	public  String saveUser(@ModelAttribute("users") @Valid Users user,BindingResult result,Model model){
		if(result.hasErrors()){
			return "add";
		}
		System.out.println(user);
		model.addAttribute("users", user);
		return "ok";
	}
}
