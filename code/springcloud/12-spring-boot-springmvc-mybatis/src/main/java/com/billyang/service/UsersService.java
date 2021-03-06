package com.billyang.service;

import java.util.List;

import com.billyang.pojo.Users;

/**   
*    
* 项目名称：12-spring-boot-springmvc-mybatis   
* 类名称：UsersService   
* 类描述：   
* 创建人：yangcan14944   
* 创建时间：2018-9-26 下午2:07:58   
* 修改人：yangcan14944   
* 修改时间：2018-9-26 下午2:07:58   
* 修改备注：   
* @version    
*    
*/
public interface UsersService {
	void addUser(Users users);
	List<Users> findUserAll();
	Users getUsersById(Integer id);
	void updateUser(Users users);
	void removeUserById(Integer id);
}
