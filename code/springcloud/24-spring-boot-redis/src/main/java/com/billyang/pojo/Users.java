package com.billyang.pojo;

import java.io.Serializable;

/**   
*    
* 项目名称：24-spring-boot-redis   
* 类名称：Users   
* 类描述：   
* 创建人：yangcan14944   
* 创建时间：2018-10-10 下午3:10:47   
* 修改人：yangcan14944   
* 修改时间：2018-10-10 下午3:10:47   
* 修改备注：   
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
