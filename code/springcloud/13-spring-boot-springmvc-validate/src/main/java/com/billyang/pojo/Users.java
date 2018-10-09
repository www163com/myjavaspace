package com.billyang.pojo;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;





/**   
*    
* 项目名称：13-spring-boot-springmvc-validate   
* 类名称：Users   
* 类描述：   实现服务端的校验
* 创建人：yangcan14944   
* 创建时间：2018-9-29 下午2:51:39   
* 修改人：yangcan14944   
* 修改时间：2018-9-29 下午2:51:39   
* 修改备注：   
* @version    
*    
*/
public class Users {
	@Email//邮箱
	@NotBlank(message="用户姓名不能为空")//非空校验
	private String name;
	@NotBlank//非空校验
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
