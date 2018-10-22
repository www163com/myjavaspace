package com.billyang.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.billyang.pojo.User;

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
	@RequestMapping("/user")
	public List<User> getUsers(){
		List<User> list = new ArrayList<>();
		list.add(new User(1,"����",20));
		list.add(new User(2,"����",20));
		list.add(new User(3,"����",20));
		return list;
	}
}
