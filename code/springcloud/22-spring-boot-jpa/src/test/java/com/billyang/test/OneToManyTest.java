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
* ��Ŀ���ƣ�22-spring-boot-jpa   
* �����ƣ�OneToManyTest   
* ��������   һ�Զ������
* �����ˣ�yangcan14944   
* ����ʱ�䣺2018-10-9 ����3:31:04   
* �޸��ˣ�yangcan14944   
* �޸�ʱ�䣺2018-10-9 ����3:31:04   
* �޸ı�ע��   
* @version    
*    
*/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=App22.class)
public class OneToManyTest {
	@Autowired
	private UsersRepository usersRepository;

	/**
	 * һ�Զ��ϵ������
	 */
	@Test
	public void testSave(){
		//�����û�
		Users users = new Users();
		users.setAddress("���ɹ�");
		users.setAge(32);
		users.setName("С��");
		//������ɫ
		Role role = new Role();
		role.setRoleName("����Ա");
		//����
		role.getUsers().add(users);
		users.setRole(role);
		//����
		this.usersRepository.save(users);
	}
	/**
	 * һ�Զ��ϵ�Ĳ�ѯ
	 */
	@Test
	public void testFind(){
		Optional<Users> user = this.usersRepository.findById(5);
		System.out.println(user.get());
		Role role = user.get().getRole();
		System.out.println(role.getRoleName());
	}
}