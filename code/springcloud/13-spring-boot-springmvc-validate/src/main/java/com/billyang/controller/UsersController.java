package com.billyang.controller;

import org.springframework.stereotype.Controller;
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
	public String showPage(){
		return "add";
	}
	//����û�����
	@RequestMapping("/save")
	public  String saveUser(Users user){
		System.out.println(user);
		return "ok";
	}
}