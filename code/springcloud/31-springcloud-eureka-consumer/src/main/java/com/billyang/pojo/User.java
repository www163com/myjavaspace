package com.billyang.pojo;

/**   
*    
* ��Ŀ���ƣ�31-springcloud-eureka-provider   
* �����ƣ�User   
* ��������   
* �����ˣ�yangcan14944   
* ����ʱ�䣺2018-10-22 ����10:32:04   
* �޸��ˣ�yangcan14944   
* �޸�ʱ�䣺2018-10-22 ����10:32:04   
* �޸ı�ע��   
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
