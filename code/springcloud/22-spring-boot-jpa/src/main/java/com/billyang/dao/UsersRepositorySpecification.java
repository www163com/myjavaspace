package com.billyang.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.billyang.pojo.Users;

/**   
*    
* 项目名称：22-spring-boot-jpa   
* 类名称：UsersRepositorySpecification   
* 类描述：   
* 创建人：yangcan14944   
* 创建时间：2018-10-9 下午2:28:52   
* 修改人：yangcan14944   
* 修改时间：2018-10-9 下午2:28:52   
* 修改备注：   
* @version    
*    
*/
public interface UsersRepositorySpecification extends JpaRepository<Users, Integer>,JpaSpecificationExecutor<Users>{

}
