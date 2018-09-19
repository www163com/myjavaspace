package com.billyang.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.billyang.pojo.User;

/**   
*    
* 项目名称：08-spring-boot-view-jsp   
* 类名称：UserController   
* 类描述：   
* 创建人：yangcan14944   
* 创建时间：2018-9-19 上午10:27:38   
* 修改人：yangcan14944   
* 修改时间：2018-9-19 上午10:27:38   
* 修改备注：   
* @version    
*    
*/
@Controller
public class UserController {

	/*
	 * 显示用户
	 */
	@RequestMapping("/showUser")
	public String showUser(Model model) {
		List<User> list = new ArrayList<>();
		list.add(new User(1, 20, "张三"));
		list.add(new User(2, 22, "李四"));
		list.add(new User(3, 24, "王五"));
		// 需要一个Model
		model.addAttribute("list2", list);
		// 页面跳转
		return "userList";
	}
}
