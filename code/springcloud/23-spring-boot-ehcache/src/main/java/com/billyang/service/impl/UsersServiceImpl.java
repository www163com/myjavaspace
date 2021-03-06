package com.billyang.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.billyang.dao.UsersRepository;
import com.billyang.pojo.Users;
import com.billyang.service.UsersService;

/**   
*    
* 项目名称：23-spring-boot-ehcache   
* 类名称：UsersServiceImpl   
* 类描述：   
* 创建人：yangcan14944   
* 创建时间：2018-10-10 上午9:40:31   
* 修改人：yangcan14944   
* 修改时间：2018-10-10 上午9:40:31   
* 修改备注：   
* @version    
*    
*/
@Service
public class UsersServiceImpl implements UsersService{

	@Autowired
	private UsersRepository usersRepository;
	
	@Override
	@Cacheable(value="users")
	public List<Users> findUserAll() {
		return this.usersRepository.findAll();
	}

	@Override
	//@Cacheable：表示对当前查询的对象做缓存处理
	@Cacheable(value="users")
	public Users findUserById(Integer id) {
	    return this.usersRepository.findById(id).get();
	}

	@Override
	@Cacheable(value="users",key="#pageable")
	public Page<Users> findUserByPage(Pageable pageable) {
		return this.usersRepository.findAll(pageable);
	}

	@Override
	@CacheEvict(value="users",allEntries=true)
	public void saveUsers(Users users) {
		this.usersRepository.save(users);
	}

}
