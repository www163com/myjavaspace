package com.billyang.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.billyang.App19;
import com.billyang.service.UserServiceImpl;

/**   
*    
* 项目名称：19-spring-boot-junit   
* 类名称：UserServiceTest   
* 类描述：   springboot整合junit
* 创建人：yangcan14944   
* 创建时间：2018-9-30 上午11:31:02   
* 修改人：yangcan14944   
* 修改时间：2018-9-30 上午11:31:02   
* 修改备注：   
* @version    
*    
*/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes={App19.class})
public class UserServiceTest {
	@Autowired
	private UserServiceImpl userService;
	@Test
	public void testAddUser(){
		this.userService.addUser();
	}
}
