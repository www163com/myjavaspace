package com.billyang.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import com.billyang.pojo.Users;

/**   
*    
* ��Ŀ���ƣ�22-spring-boot-jpa   
* �����ƣ�UsersRepositoryQueryAnnotation   
* ��������   @Query
* �����ˣ�yangcan14944   
* ����ʱ�䣺2018-10-9 ����9:22:50   
* �޸��ˣ�yangcan14944   
* �޸�ʱ�䣺2018-10-9 ����9:22:50   
* �޸ı�ע��   
* @version    
*    
*/
public interface UsersRepositoryQueryAnnotation extends Repository<Users, Integer>{
	@Query("from Users where name = ?1")
	List<Users> queryByNameUseHQL(String name);
	@Query(value="select * from t_users where name=?",nativeQuery=true)
	List<Users> queryByNameUseSQL(String name);
	@Query("update Users set name=?1 where id = ?2")
	@Modifying  //��ʾ���²���
	void updateUsersNameById(String name,Integer id);
}