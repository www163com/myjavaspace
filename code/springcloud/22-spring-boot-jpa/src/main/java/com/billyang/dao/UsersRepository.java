package com.billyang.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.billyang.pojo.Users;

/**   
*    
* 项目名称：22-spring-boot-jpa   
* 类名称：UsersRepostory   
* 类描述：   
* 创建人：yangcan14944   
* 创建时间：2018-10-8 下午4:16:49   
* 修改人：yangcan14944   
* 修改时间：2018-10-8 下午4:16:49   
* 修改备注：   
* @version    
*    参数一T:当前需要映射的实体
*    参数二ID：当前映射实体的主键类型
*/
public interface UsersRepository extends JpaRepository<Users, Integer>{

}
