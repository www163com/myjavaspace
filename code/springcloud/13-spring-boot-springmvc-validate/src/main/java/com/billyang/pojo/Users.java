package com.billyang.pojo;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;





/**   
*    
* ��Ŀ���ƣ�13-spring-boot-springmvc-validate   
* �����ƣ�Users   
* ��������   ʵ�ַ���˵�У��
* �����ˣ�yangcan14944   
* ����ʱ�䣺2018-9-29 ����2:51:39   
* �޸��ˣ�yangcan14944   
* �޸�ʱ�䣺2018-9-29 ����2:51:39   
* �޸ı�ע��   
* @version    
*    
*/
public class Users {
	@Email//����
	@NotBlank(message="�û���������Ϊ��")//�ǿ�У��
	private String name;
	@NotBlank//�ǿ�У��
	private String password;
	private Integer age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Users [name=" + name + ", password=" + password + ", age="
				+ age + ", getName()=" + getName() + ", getPassword()="
				+ getPassword() + ", getAge()=" + getAge() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	

}
