package com.billyang.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.billyang.pojo.User;
import com.billyang.service.UserService;

/**   
*    
* 项目名称：31-springcloud-eureka-provider   
* 类名称：UsersController   
* 类描述：   
* 创建人：yangcan14944   
* 创建时间：2018-10-22 上午10:31:45   
* 修改人：yangcan14944   
* 修改时间：2018-10-22 上午10:31:45   
* 修改备注：   
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
