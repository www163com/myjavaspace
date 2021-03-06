package com.billyang.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.billyang.pojo.Users;

/**   
*    
* 项目名称：22-spring-boot-jpa   
* 类名称：UsersRepositoryPadingAndSorting   
* 类描述：   PagingAndSortingRepository 接口
* 创建人：yangcan14944   
* 创建时间：2018-10-9 上午10:15:07   
* 修改人：yangcan14944   
* 修改时间：2018-10-9 上午10:15:07   
* 修改备注：   
* @version    
*    
*/
public interface UsersRepositoryPadingAndSorting extends PagingAndSortingRepository<Users, Integer> {

}
