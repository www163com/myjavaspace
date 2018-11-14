package com.billyang.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.billyang.pojo.User;
import com.billyang.service.UserService;

/**   
*    
* ��Ŀ���ƣ�31-springcloud-eureka-provider   
* �����ƣ�UsersController   
* ��������   
* �����ˣ�yangcan14944   
* ����ʱ�䣺2018-10-22 ����10:31:45   
* �޸��ˣ�yangcan14944   
* �޸�ʱ�䣺2018-10-22 ����10:31:45   
* �޸ı�ע��   
* @version    
*    
*/
@RestController
public class UsersController {
	@Autowired
	private UserService userService;
	@RequestMapping("/consumer")
	public List<User> getUsers(){
		return this.userService.getUsers();
	}
}