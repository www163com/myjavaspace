package com.billyang.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.billyang.App23;
import com.billyang.pojo.Users;
import com.billyang.service.UsersService;

/**   
*    
* ��Ŀ���ƣ�23-spring-boot-ehcache   
* �����ƣ�UsersServiceTest   
* ��������   
* �����ˣ�yangcan14944   
* ����ʱ�䣺2018-10-10 ����9:43:37   
* �޸��ˣ�yangcan14944   
* �޸�ʱ�䣺2018-10-10 ����9:43:37   
* �޸ı�ע��   
* @version    
*    
*/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=App23.class)
public class UsersServiceTest {
	@Autowired
	private UsersService usersService;
	@Test
	public void testFindUserById(){
		//��һ�β�ѯ
		System.out.println(this.usersService.findUserById(1));
		
		//�ڶ��β�ѯ
		System.out.println(this.usersService.findUserById(1));
	}
	@Test
	public void testFindUsersByPage(){
		Pageable pageable = new PageRequest(0, 2);
	    //��һ�β�ѯ
		List<Users> list1 = this.usersService.findUserByPage(pageable).getContent();
		for (Users users : list1) {
			System.out.println(users);
		}
		//System.out.println(this.usersService.findUserByPage(pageable).getTotalElements());
		//�ڶ��β�ѯ
		List<Users> list2 = this.usersService.findUserByPage(pageable).getContent();
		for (Users users : list2) {
			System.out.println(users);
		}
		//System.out.println(this.usersService.findUserByPage(pageable).getTotalElements());
		//�����β�ѯ 
		pageable = new PageRequest(1, 2);
		List<Users> list3 = this.usersService.findUserByPage(pageable).getContent();
		for (Users users : list3) {
			System.out.println(users);
		}
		//System.out.println(this.usersService.findUserByPage(pageable).getTotalElements());
	}
	@Test
	public void testFindAll(){
		//��һ�β�ѯ
		System.out.println(this.usersService.findUserAll().size());
		Users users = new Users();
		users.setAddress("����");
		users.setAge(32);
		users.setName("hello2");
		this.usersService.saveUsers(users);
		//�ڶ��β�ѯ
		System.out.println(this.usersService.findUserAll().size());
	}
}