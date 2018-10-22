package com.billyang.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.billyang.pojo.User;

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
	@RequestMapping("/user")
	public List<User> getUsers(){
		List<User> list = new ArrayList<>();
		list.add(new User(1,"张三",20));
		list.add(new User(2,"李四",20));
		list.add(new User(3,"王五",20));
		return list;
	}
}
