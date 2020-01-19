package com.hcl.jsh.dao;

import com.hcl.jsh.model.Users;

public interface UsersDAO 
{
	public boolean addUser(Users u);
	public boolean checkUser(String userid,String password);
	public boolean updateUser(Users u);
	public boolean changePassword(String userid);
	public boolean forgotPassword(String userid);
	public String getName(Users u);
}
