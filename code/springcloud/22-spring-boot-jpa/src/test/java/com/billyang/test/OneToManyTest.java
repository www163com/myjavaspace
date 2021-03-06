package com.billyang.test;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.billyang.App22;
import com.billyang.dao.UsersRepository;
import com.billyang.pojo.Role;
import com.billyang.pojo.Users;

/**   
*    
* 项目名称：22-spring-boot-jpa   
* 类名称：OneToManyTest   
* 类描述：   一对多测试类
* 创建人：yangcan14944   
* 创建时间：2018-10-9 下午3:31:04   
* 修改人：yangcan14944   
* 修改时间：2018-10-9 下午3:31:04   
* 修改备注：   
* @version    
*    
*/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=App22.class)
public class OneToManyTest {
	@Autowired
	private UsersRepository usersRepository;

	/**
	 * 一对多关系的添加
	 */
	@Test
	public void testSave(){
		//创建用户
		Users users = new Users();
		users.setAddress("内蒙古");
		users.setAge(32);
		users.setName("小芳");
		//创建角色
		Role role = new Role();
		role.setRoleName("管理员");
		//关联
		role.getUsers().add(users);
		users.setRole(role);
		//保存
		this.usersRepository.save(users);
	}
	/**
	 * 一对多关系的查询
	 */
	@Test
	public void testFind(){
		Optional<Users> user = this.usersRepository.findById(5);
		System.out.println(user.get());
		Role role = user.get().getRole();
		System.out.println(role.getRoleName());
	}
}
