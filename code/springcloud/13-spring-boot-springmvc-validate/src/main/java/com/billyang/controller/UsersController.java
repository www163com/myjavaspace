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
* ��Ŀ���ƣ�13-spring-boot-springmvc-validate   
* �����ƣ�UsersController   
* ��������   �����У��
* �����ˣ�yangcan14944   
* ����ʱ�䣺2018-9-29 ����2:52:43   
* �޸��ˣ�yangcan14944   
* �޸�ʱ�䣺2018-9-29 ����2:52:43   
* �޸ı�ע��   
* @version    
*    
*/
@Controller
public class UsersController {
	@RequestMapping("/addUser")
	public String showPage(Users users){
		return "add";
	}
	//����û����
	/**
	 * @param user
	 * @param result
	 * @return
	 * BindingResult ��װ��У��Ľ��
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
