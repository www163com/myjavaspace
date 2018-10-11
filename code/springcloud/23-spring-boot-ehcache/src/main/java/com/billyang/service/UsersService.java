package com.billyang.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.billyang.pojo.Users;

/**   
*    
* ��Ŀ���ƣ�23-spring-boot-ehcache   
* �����ƣ�UsersService   
* ��������   
* �����ˣ�yangcan14944   
* ����ʱ�䣺2018-10-10 ����9:34:47   
* �޸��ˣ�yangcan14944   
* �޸�ʱ�䣺2018-10-10 ����9:34:47   
* �޸ı�ע��   
* @version    
*    
*/
public interface UsersService {
	List<Users> findUserAll();
	Users findUserById(Integer id);
	Page<Users> findUserByPage(Pageable pageable);
	void saveUsers(Users users);
}
