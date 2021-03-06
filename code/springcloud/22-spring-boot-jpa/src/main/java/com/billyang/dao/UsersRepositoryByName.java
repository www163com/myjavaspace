package com.billyang.dao;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.billyang.pojo.Users;

/**   
*    
* 项目名称：22-spring-boot-jpa   
* 类名称：UsersRepositoryByName   
* 类描述：   
* 创建人：yangcan14944   
* 创建时间：2018-10-8 下午4:48:34   
* 修改人：yangcan14944   
* 修改时间：2018-10-8 下午4:48:34   
* 修改备注：   
* @version    
*    Repository方法名称命名查询
*/
public interface UsersRepositoryByName extends Repository<Users, Integer>{
	//方法的名称必须遵循驼峰命名规则 findBy(关键字)+属性名称(首字母大写)+查询条件(首字母大写)
	public List<Users> findByName(String name);
	public List<Users> findByNameAndAge(String name,Integer age);
	public List<Users> findByNameLike(String name);
}
