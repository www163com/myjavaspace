package com.billyang.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.billyang.pojo.User;

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
		model.addAttribute("key", new Date());
		return "index";
	}
	@RequestMapping("/show2")
	public String showInfo2(Model model) {
		model.addAttribute("sex", "男");
		model.addAttribute("ID", 2);
		return "index2";
	}
	@RequestMapping("/show3")
	public String showInfo3(Model model) {
		List<User> list = new ArrayList<>();
		list.add(new User(1,20,"张三"));
		list.add(new User(2,22,"李四"));
		list.add(new User(3,24,"王五"));
		model.addAttribute("list", list);
		return "index3";
	}
	@RequestMapping("/show4")
	public String showInfo4(Model model) {
		Map<String, User> map = new HashMap<>();
		map.put("u1", new User(1,20,"张三"));
		map.put("u2", new User(1,22,"李四"));
		map.put("u3", new User(1,24,"王五"));
		model.addAttribute("map", map);
		return "index4";
	}
	@RequestMapping("/show5")
	public String showInfo5(HttpServletRequest request,Model model) {
		request.setAttribute("req", "HttpServletRequest");
		request.getSession().setAttribute("sess", "HttpSession");
		request.getSession().getServletContext().setAttribute("app", "application");
		return "index5";
	}
}
