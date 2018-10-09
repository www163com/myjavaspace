package com.billyang.pojo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**   
*    
* ��Ŀ���ƣ�22-spring-boot-jpa   
* �����ƣ�Role   
* ��������   
* �����ˣ�yangcan14944   
* ����ʱ�䣺2018-10-9 ����3:17:33   
* �޸��ˣ�yangcan14944   
* �޸�ʱ�䣺2018-10-9 ����3:17:33   
* �޸ı�ע��   
* @version    
*    
*/
@Entity
@Table(name="t_role")
public class Role {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="roleId")
	private Integer roleId;
	@Column(name="roleName")
	private String roleName;
	@OneToMany(mappedBy="role")
	private Set<Users> users = new HashSet<>();
	@ManyToMany(mappedBy="roles",cascade=CascadeType.PERSIST,fetch=FetchType.EAGER)
	private Set<Menus> menus = new HashSet<>();
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public Set<Users> getUsers() {
		return users;
	}
	public void setUsers(Set<Users> users) {
		this.users = users;
	}
	public Set<Menus> getMenus() {
		return menus;
	}
	public void setMenus(Set<Menus> menus) {
		this.menus = menus;
	}
	@Override
	public String toString() {
		return "role [id:"+this.getRoleId()+",name:"+this.getRoleName()+"]";
	}
}