package com.itheima.dao;

/**
 * 用户信息的封装类
 * 
 * @author 长孙建坤 18092853734
 * @version 1.0 ，2017-05-08 18:03:56
 */
public class UserBean {
	/** 用户名 */
	private String userName;
	
	/** 密码 */
	private String password;
	
	/** 无参构造器*/
	public UserBean() {}
	
	/** 有参构造器 */
	public UserBean (String userName,String password){
		this.userName = userName;
		this.password = password;
	}

	/**
	 * 获取用户名
	 * @return 用户名
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * 设置用户名
	 * @param userName 用户名
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * 获取密码
	 * @return 密码
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * 设置密码
	 * @param password 密码
	 */
	public void setPassword(String password) {
		this.password = password;
	}
}
