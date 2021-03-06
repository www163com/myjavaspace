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
* 项目名称：22-spring-boot-jpa   
* 类名称：ManyToManyTest   
* 类描述：   多对多的关联关系的测试
* 创建人：yangcan14944   
* 创建时间：2018-10-9 下午3:58:17   
* 修改人：yangcan14944   
* 修改时间：2018-10-9 下午3:58:17   
* 修改备注：   
* @version    
*    
*/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=App22.class)
public class ManyToManyTest {
	@Autowired
	private RoleRepository roleRepository;
	
	/**
	 * 添加测试
	 */
	@Test
	public void testSave(){
		//创建角色
		Role r = new Role();
		r.setRoleName("项目经理");
		//创建菜单
		Menus m = new Menus();
		m.setMenusName("xxx管理系统");
		m.setFatherId(0);
		Menus m2 = new Menus();
		m2.setFatherId(1);
		m2.setMenusName("项目管理");
		//关联
		r.getMenus().add(m);
		r.getMenus().add(m2);
		m.getRoles().add(r);
		m2.getRoles().add(r);
		//保存
		this.roleRepository.save(r);
	}
	/**
	 * 测试 多对多
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
