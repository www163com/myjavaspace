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
* 项目名称：23-spring-boot-ehcache   
* 类名称：UsersServiceTest   
* 类描述：   
* 创建人：yangcan14944   
* 创建时间：2018-10-10 上午9:43:37   
* 修改人：yangcan14944   
* 修改时间：2018-10-10 上午9:43:37   
* 修改备注：   
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
		//第一次查询
		System.out.println(this.usersService.findUserById(1));
		
		//第二次查询
		System.out.println(this.usersService.findUserById(1));
	}
	@Test
	public void testFindUsersByPage(){
		Pageable pageable = new PageRequest(0, 2);
	    //第一次查询
		List<Users> list1 = this.usersService.findUserByPage(pageable).getContent();
		for (Users users : list1) {
			System.out.println(users);
		}
		//System.out.println(this.usersService.findUserByPage(pageable).getTotalElements());
		//第二次查询
		List<Users> list2 = this.usersService.findUserByPage(pageable).getContent();
		for (Users users : list2) {
			System.out.println(users);
		}
		//System.out.println(this.usersService.findUserByPage(pageable).getTotalElements());
		//第三次查询 
		pageable = new PageRequest(1, 2);
		List<Users> list3 = this.usersService.findUserByPage(pageable).getContent();
		for (Users users : list3) {
			System.out.println(users);
		}
		//System.out.println(this.usersService.findUserByPage(pageable).getTotalElements());
	}
	@Test
	public void testFindAll(){
		//第一次查询
		System.out.println(this.usersService.findUserAll().size());
		Users users = new Users();
		users.setAddress("美国");
		users.setAge(32);
		users.setName("hello2");
		this.usersService.saveUsers(users);
		//第二次查询
		System.out.println(this.usersService.findUserAll().size());
	}
}
