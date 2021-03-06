package com.billyang.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.billyang.pojo.Users;
import com.billyang.service.UsersService;

/**   
*    
* 项目名称：12-spring-boot-springmvc-mybatis   
* 类名称：UsersController   
* 类描述：   
* 创建人：yangcan14944   
* 创建时间：2018-9-26 下午2:11:30   
* 修改人：yangcan14944   
* 修改时间：2018-9-26 下午2:11:30   
* 修改备注：   
* @version    
*    
*/
@Controller
@RequestMapping("/users")
public class UsersController {
	@Autowired
	private UsersService usersService;
	/*
	 * 页面跳转
	 * */
	@RequestMapping("/{page}")
	public String showPage(@PathVariable String page){
		return page;
	}
	/*
	 * 添加用户
	 * */
	@RequestMapping("/addUser")
	public String addUser(Users users){
		this.usersService.addUser(users);
		return "ok";
	}
	/**
	 * 查询全部用户
	 * @param model
	 * @return
	 */
	@RequestMapping("/showUsers")
	public String findUserAll(Model model){
		List<Users> list = this.usersService.findUserAll();
		model.addAttribute("list", list);
		return "showUsers";
	}
	/**
	 * 根据ID查询用户
	 * @param model
	 * @return
	 */
	@RequestMapping("/findUserById")
	public String findUsersById(Integer id,Model model){
		Users user = this.usersService.getUsersById(id);
		model.addAttribute("user", user);
		return "updateUser";
	}
	/**
	 * 根据ID查询用户
	 * @param model
	 * @return
	 */
	@RequestMapping("/editUser")
	public String editUser(Users users){
		this.usersService.updateUser(users);
		return "ok";
	}
	/**
	 * 根据ID删除用户
	 * @param model
	 * @return
	 */
	@RequestMapping("/deluserById")
	public String delUserById(Integer id){
		this.usersService.removeUserById(id);
		return "ok";
	}
}
