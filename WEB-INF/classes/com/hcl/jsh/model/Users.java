package com.hcl.jsh.model;

public class Users 
{
	String userid;
	String name;
	String password;
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
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
	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Users(String userid, String name, String password) {
		super();
		this.userid = userid;
		this.name = name;
		this.password = password;
	}
	@Override
	public String toString() {
		return "Users [userid=" + userid + ", name=" + name + ", password="
				+ password + "]";
	}
	
	
	

}
