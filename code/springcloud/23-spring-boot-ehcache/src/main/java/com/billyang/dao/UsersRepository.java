package com.billyang.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.billyang.pojo.Users;

/**   
*    
* ��Ŀ���ƣ�23-spring-boot-ehcache   
* �����ƣ�UsersRepository   
* ��������   
* �����ˣ�yangcan14944   
* ����ʱ�䣺2018-10-10 ����9:32:11   
* �޸��ˣ�yangcan14944   
* �޸�ʱ�䣺2018-10-10 ����9:32:11   
* �޸ı�ע��   
* @version    
*    ����һT:��ǰ��Ҫӳ���ʵ��
*    ������ID����ǰӳ��ʵ�����������
*/
public interface UsersRepository extends JpaRepository<Users, Integer>{

}
