package com.billyang.dao;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.billyang.pojo.Users;

/**   
*    
* ��Ŀ���ƣ�22-spring-boot-jpa   
* �����ƣ�UsersRepositoryByName   
* ��������   
* �����ˣ�yangcan14944   
* ����ʱ�䣺2018-10-8 ����4:48:34   
* �޸��ˣ�yangcan14944   
* �޸�ʱ�䣺2018-10-8 ����4:48:34   
* �޸ı�ע��   
* @version    
*    Repository��������������ѯ
*/
public interface UsersRepositoryByName extends Repository<Users, Integer>{
	//���������Ʊ�����ѭ�շ��������� findBy(�ؼ���)+��������(����ĸ��д)+��ѯ����(����ĸ��д)
	public List<Users> findByName(String name);
	public List<Users> findByNameAndAge(String name,Integer age);
	public List<Users> findByNameLike(String name);
}