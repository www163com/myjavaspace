package com.billyang.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
/**   
*    
* 项目名称：23-spring-boot-ehcache   
* 类名称：Users   
* 类描述：   
* 创建人：yangcan14944   
* 创建时间：2018-10-10 上午9:31:36   
* 修改人：yangcan14944   
* 修改时间：2018-10-10 上午9:31:36   
* 修改备注：   
* @version    
*    
*/
@Entity
@Table(name="t_users")
public class Users implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "users [id:"+this.getId()+",name:"+this.getName()+",age:"+this.getAge()+",address:"+this.getAddress()+"]";
	}
}
