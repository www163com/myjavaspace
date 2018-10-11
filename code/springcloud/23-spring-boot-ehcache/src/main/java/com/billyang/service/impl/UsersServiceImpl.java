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
* ��Ŀ���ƣ�23-spring-boot-ehcache   
* �����ƣ�UsersServiceImpl   
* ��������   
* �����ˣ�yangcan14944   
* ����ʱ�䣺2018-10-10 ����9:40:31   
* �޸��ˣ�yangcan14944   
* �޸�ʱ�䣺2018-10-10 ����9:40:31   
* �޸ı�ע��   
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
	//@Cacheable����ʾ�Ե�ǰ��ѯ�Ķ��������洦��
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