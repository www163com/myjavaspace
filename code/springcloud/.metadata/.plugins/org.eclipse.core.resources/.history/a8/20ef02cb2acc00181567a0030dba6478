package com.billyang.pojo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**   
*    
* 项目名称：22-spring-boot-jpa   
* 类名称：Menus   
* 类描述：   
* 创建人：yangcan14944   
* 创建时间：2018-10-9 下午3:44:22   
* 修改人：yangcan14944   
* 修改时间：2018-10-9 下午3:44:22   
* 修改备注：   
* @version    
*    
*/
@Entity
@Table(name="t_menus")
public class Menus {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="munus_id")
	private Integer menusId;
	@Column(name="munus_name")
	private String menusName;
	@Column(name="munus_url")
	private String menusUrl;
	@Column(name="munus_father_id")
	private Integer fatherId;
	@ManyToMany(cascade=CascadeType.PERSIST)
	//@JoinTable：映射中间表
	//joinColumns：当前表中的主键关联中间表的外键
	@JoinTable(name="t_role_menus",joinColumns=@JoinColumn(name="menu_id"),inverseJoinColumns=@JoinColumn(name="role_id"))
	private Set<Role> roles = new HashSet<>();
	public Integer getMenusId() {
		return menusId;
	}
	public void setMenusId(Integer menusId) {
		this.menusId = menusId;
	}
	public String getMenusName() {
		return menusName;
	}
	public void setMenusName(String menusName) {
		this.menusName = menusName;
	}
	public String getMenusUrl() {
		return menusUrl;
	}
	public void setMenusUrl(String menusUrl) {
		this.menusUrl = menusUrl;
	}
	public Integer getFatherId() {
		return fatherId;
	}
	public void setFatherId(Integer fatherId) {
		this.fatherId = fatherId;
	}
	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	@Override
	public String toString() {
		return "menus [id:"+this.getMenusId()+",name:"+this.getMenusName()+"]";
	}
}
