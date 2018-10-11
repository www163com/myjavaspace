package com.billyang.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.billyang.pojo.Users;

/**   
*    
* 项目名称：23-spring-boot-ehcache   
* 类名称：UsersRepository   
* 类描述：   
* 创建人：yangcan14944   
* 创建时间：2018-10-10 上午9:32:11   
* 修改人：yangcan14944   
* 修改时间：2018-10-10 上午9:32:11   
* 修改备注：   
* @version    
*    参数一T:当前需要映射的实体
*    参数二ID：当前映射实体的主键类型
*/
public interface UsersRepository extends JpaRepository<Users, Integer>{

}
