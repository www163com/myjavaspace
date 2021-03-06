package com.billyang.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import com.billyang.pojo.Users;

/**   
*    
* 项目名称：22-spring-boot-jpa   
* 类名称：UsersRepositoryQueryAnnotation   
* 类描述：   @Query
* 创建人：yangcan14944   
* 创建时间：2018-10-9 上午9:22:50   
* 修改人：yangcan14944   
* 修改时间：2018-10-9 上午9:22:50   
* 修改备注：   
* @version    
*    
*/
public interface UsersRepositoryQueryAnnotation extends Repository<Users, Integer>{
	@Query("from Users where name = ?1")
	List<Users> queryByNameUseHQL(String name);
	@Query(value="select * from t_users where name=?",nativeQuery=true)
	List<Users> queryByNameUseSQL(String name);
	@Query("update Users set name=?1 where id = ?2")
	@Modifying  //表示更新操作
	void updateUsersNameById(String name,Integer id);
}
