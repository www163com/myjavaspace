package com.billyang.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.billyang.pojo.Users;

/**   
*    
* ��Ŀ���ƣ�22-spring-boot-jpa   
* �����ƣ�UsersRepositoryPadingAndSorting   
* ��������   PagingAndSortingRepository �ӿ�
* �����ˣ�yangcan14944   
* ����ʱ�䣺2018-10-9 ����10:15:07   
* �޸��ˣ�yangcan14944   
* �޸�ʱ�䣺2018-10-9 ����10:15:07   
* �޸ı�ע��   
* @version    
*    
*/
public interface UsersRepositoryPadingAndSorting extends PagingAndSortingRepository<Users, Integer> {

}