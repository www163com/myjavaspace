package com.billyang.pojo;

/**   
*    
* 项目名称：12-spring-boot-springmvc-mybatis   
* 类名称：Users   
* 类描述：   整合springmvc、mybatis实体类
* 创建人：yangcan14944   
* 创建时间：2018-9-26 下午1:56:25   
* 修改人：yangcan14944   
* 修改时间：2018-9-26 下午1:56:25   
* 修改备注：   
* @version    
*    
*/
public class Users {
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
}
