package com.billyang.pojo;

import java.io.Serializable;

/**   
*    
* ��Ŀ���ƣ�24-spring-boot-redis   
* �����ƣ�Users   
* ��������   
* �����ˣ�yangcan14944   
* ����ʱ�䣺2018-10-10 ����3:10:47   
* �޸��ˣ�yangcan14944   
* �޸�ʱ�䣺2018-10-10 ����3:10:47   
* �޸ı�ע��   
* @version    
*    
*/
public class Users implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
	private Integer age;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Users--[id:"+this.getId()+",name:"+this.getName()+",age:"+this.getAge()+"]";
	}

}
