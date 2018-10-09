package com.billyang.test;

import java.util.Optional;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.billyang.App22;
import com.billyang.dao.RoleRepository;
import com.billyang.pojo.Menus;
import com.billyang.pojo.Role;

/**   
*    
* ��Ŀ���ƣ�22-spring-boot-jpa   
* �����ƣ�ManyToManyTest   
* ��������   ��Զ�Ĺ�����ϵ�Ĳ���
* �����ˣ�yangcan14944   
* ����ʱ�䣺2018-10-9 ����3:58:17   
* �޸��ˣ�yangcan14944   
* �޸�ʱ�䣺2018-10-9 ����3:58:17   
* �޸ı�ע��   
* @version    
*    
*/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=App22.class)
public class ManyToManyTest {
	@Autowired
	private RoleRepository roleRepository;
	
	/**
	 * ���Ӳ���
	 */
	@Test
	public void testSave(){
		//������ɫ
		Role r = new Role();
		r.setRoleName("��Ŀ����");
		//�����˵�
		Menus m = new Menus();
		m.setMenusName("xxx����ϵͳ");
		m.setFatherId(0);
		Menus m2 = new Menus();
		m2.setFatherId(1);
		m2.setMenusName("��Ŀ����");
		//����
		r.getMenus().add(m);
		r.getMenus().add(m2);
		m.getRoles().add(r);
		m2.getRoles().add(r);
		//����
		this.roleRepository.save(r);
	}
	/**
	 * ���� ��Զ�
	 */
	@Test
	public void testFind(){
		Optional<Role> r = this.roleRepository.findById(4);
		System.out.println(r.get());
		Set<Menus> set = r.get().getMenus();
		for (Menus menus : set) {
			System.out.println(menus);
		}
	}
}