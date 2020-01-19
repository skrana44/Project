package com.hcl.jsh.actions;

import com.hcl.jsh.dao.UsersImpl;
import com.hcl.jsh.model.Users;

public class UserService 
{
	UsersImpl userImp=new UsersImpl();
	public Users createUser(Users user)
	{
		
		if(userImp.addUser(user))
			return user;
		else
			return null;
		
	}
	public String validateLogin(Users user)
	{
		if(userImp.checkUser(user.getUserid(), user.getPassword()))
			return userImp.getName(user);
		else
			return null;
	}
}
