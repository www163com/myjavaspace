package com.billyang.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.billyang.mapper.UsersMapper;
import com.billyang.pojo.Users;
import com.billyang.service.UsersService;

/**   
*    
* 项目名称：12-spring-boot-springmvc-mybatis   
* 类名称：UsersServiceImpl   
* 类描述：   
* 创建人：yangcan14944   
* 创建时间：2018-9-26 下午2:08:40   
* 修改人：yangcan14944   
* 修改时间：2018-9-26 下午2:08:40   
* 修改备注：   
* @version    
*    
*/
@Service
@Transactional
public class UsersServiceImpl implements UsersService{
	@Autowired
	private UsersMapper usersMapper;
	@Override
	public void addUser(Users users) {
		this.usersMapper.insertUser(users);
	}
	@Override
	public List<Users> findUserAll() {
		return this.usersMapper.selectUsersAll();
	}
	@Override
	public Users getUsersById(Integer id) {
		return this.usersMapper.selectUsersById(id);
	}
	@Override
	public void updateUser(Users users) {
		this.usersMapper.updateUser(users);
	}
	@Override
	public void removeUserById(Integer id) {
		this.usersMapper.removeUserById(id);
	}
}
