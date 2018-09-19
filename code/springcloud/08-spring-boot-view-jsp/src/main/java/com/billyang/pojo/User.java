package com.billyang.pojo;

public class User {
	private Integer userId;
	private Integer userAge;
	private String userName;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getUserAge() {
		return userAge;
	}

	public void setUserAge(Integer userAge) {
		this.userAge = userAge;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public User() {
		super();
	}

	public User(Integer userId, Integer userAge, String userName) {
		super();
		this.userId = userId;
		this.userAge = userAge;
		this.userName = userName;
	}
}
