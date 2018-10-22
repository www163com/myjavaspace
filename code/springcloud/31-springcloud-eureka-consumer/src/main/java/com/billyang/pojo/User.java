package com.billyang.pojo;

/**   
*    
* 项目名称：31-springcloud-eureka-provider   
* 类名称：User   
* 类描述：   
* 创建人：yangcan14944   
* 创建时间：2018-10-22 上午10:32:04   
* 修改人：yangcan14944   
* 修改时间：2018-10-22 上午10:32:04   
* 修改备注：   
* @version    
*    
*/
public class User {
	private int userId;
	private String userName;
	private int userAge;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getUserAge() {
		return userAge;
	}
	public void setUserAge(int userAge) {
		this.userAge = userAge;
	}
	public User() {
		super();
	}
	public User(int userId, String userName, int userAge) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userAge = userAge;
	}
	
}
