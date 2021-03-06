package com.billyang.mapper;

import java.util.List;

import com.billyang.pojo.Users;

/**   
*    
* 项目名称：12-spring-boot-springmvc-mybatis   
* 类名称：UserMapper   
* 类描述：   
* 创建人：yangcan14944   
* 创建时间：2018-9-26 下午2:08:05   
* 修改人：yangcan14944   
* 修改时间：2018-9-26 下午2:08:05   
* 修改备注：   
* @version    
*    
*/
public interface UsersMapper {
	void insertUser(Users users);
	List<Users> selectUsersAll();
	Users selectUsersById(Integer id);
	void updateUser(Users users);
	void removeUserById(Integer id);
}
