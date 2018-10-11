package com.billyang.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.billyang.pojo.Users;

/**   
*    
* 项目名称：23-spring-boot-ehcache   
* 类名称：UsersService   
* 类描述：   
* 创建人：yangcan14944   
* 创建时间：2018-10-10 上午9:34:47   
* 修改人：yangcan14944   
* 修改时间：2018-10-10 上午9:34:47   
* 修改备注：   
* @version    
*    
*/
public interface UsersService {
	List<Users> findUserAll();
	Users findUserById(Integer id);
	Page<Users> findUserByPage(Pageable pageable);
	void saveUsers(Users users);
}
