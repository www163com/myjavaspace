package com.billyang.dao;

import org.springframework.stereotype.Repository;

/**   
*    
* 项目名称：19-spring-boot-junit   
* 类名称：UserDaoImpl   
* 类描述：   springboot整合junit
* 创建人：yangcan14944   
* 创建时间：2018-9-30 上午11:27:53   
* 修改人：yangcan14944   
* 修改时间：2018-9-30 上午11:27:53   
* 修改备注：   
* @version    
*    
*/
@Repository
public class UserDaoImpl {

	public void saveUser(){
		System.out.println("insert into users");
	}
}
