package com.billyang.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.billyang.pojo.Users;

/**   
*    
* ��Ŀ���ƣ�22-spring-boot-jpa   
* �����ƣ�UsersRepostory   
* ��������   
* �����ˣ�yangcan14944   
* ����ʱ�䣺2018-10-8 ����4:16:49   
* �޸��ˣ�yangcan14944   
* �޸�ʱ�䣺2018-10-8 ����4:16:49   
* �޸ı�ע��   
* @version    
*    ����һT:��ǰ��Ҫӳ���ʵ��
*    ������ID����ǰӳ��ʵ�����������
*/
public interface UsersRepository extends JpaRepository<Users, Integer>{

}
