package com.billyang.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.billyang.dao.UserDaoImpl;

/**   
*    
* 项目名称：19-spring-boot-junit   
* 类名称：UserServiceImpl   
* 类描述：   springboot整合 junit
* 创建人：yangcan14944   
* 创建时间：2018-9-30 上午11:28:54   
* 修改人：yangcan14944   
* 修改时间：2018-9-30 上午11:28:54   
* 修改备注：   
* @version    
*    
*/
@Service
public class UserServiceImpl {
	@Autowired
	private UserDaoImpl userDao;
	public void addUser(){
		this.userDao.saveUser();
	}

}
