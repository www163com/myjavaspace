package com.billyang.pojo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**   
*    
* ��Ŀ���ƣ�22-spring-boot-jpa   
* �����ƣ�Users   
* ��������   ʹ��spring
* �����ˣ�yangcan14944   
* ����ʱ�䣺2018-10-8 ����4:09:20   
* �޸��ˣ�yangcan14944   
* �޸�ʱ�䣺2018-10-8 ����4:09:20   
* �޸ı�ע��   
* @version    
*    
*/
@Entity
@Table(name="t_users")
public class Users {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	@Column(name="name")
	private String name;
	@Column(name="age")
	private Integer age;
	@Column(name="address")
	private String address;
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	//@JoinColumnά�����
	@JoinColumn(name="role_id")
	private Role role;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "users [id:"+this.getId()+",name:"+this.getName()+",age:"+this.getAge()+",address:"+this.getAddress()+"]";
	}
}