package com.billyang.dao;

import org.springframework.data.repository.CrudRepository;

import com.billyang.pojo.Users;

/**   
*    
* ��Ŀ���ƣ�22-spring-boot-jpa   
* �����ƣ�UsersRepositoryCrudRepository   
* ��������   CrudRepository�ӿ�
* �����ˣ�yangcan14944   
* ����ʱ�䣺2018-10-9 ����9:51:23   
* �޸��ˣ�yangcan14944   
* �޸�ʱ�䣺2018-10-9 ����9:51:23   
* �޸ı�ע��   
* @version    
*    
*/
public interface UsersRepositoryCrudRepository extends CrudRepository<Users, Integer> {

}
