package com.hcl.jsh.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.hcl.jsh.model.Jdbcutil;
import com.hcl.jsh.model.Users;


public class UsersImpl implements UsersDAO 
{

	@Override
	public boolean addUser(Users u) 
	{
		Jdbcutil.loaddriver();
		boolean flag = false;
		Connection con = null;
		con=Jdbcutil.getConnection();
		PreparedStatement ps = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "insert into user values(?,?,?)";
		String check = "select user_id from user where user_id='"+u.getUserid()+"'";
		try 
		{
			stmt = con.createStatement();
			rs = stmt.executeQuery(check);
			ps=con.prepareStatement(sql);
			if(rs.next())
			{
			flag = false;
			}
			else
			{
			ps.setString(1, u.getUserid());
			ps.setString(2, u.getName());
			ps.setString(3, u.getPassword());
			int i = ps.executeUpdate();
			
			if(i!=0)
				flag =true;
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			try 
			{
				if(ps!=null) 	ps.close();
				if(con!=null)	con.close();
			} 
			catch (SQLException e) 
			{
			e.printStackTrace();
			}
		}
		return flag;
	}

	@Override
	public boolean checkUser(String userid, String password) 
	{
		Jdbcutil.loaddriver();
		Connection con = null;
		con=Jdbcutil.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		boolean flag = false;
		try 
		{
			
			String checkuser ="select user_id,login_pwd from user where user_id=? and login_pwd=?";
			stmt=con.prepareStatement(checkuser);
			stmt.setString(1, userid);
			stmt.setString(2, password);
			
			rs = stmt.executeQuery();
			
			if(rs.next())
			{
					flag=true;
			}
			
		}
		catch (SQLException e2) {
			
			e2.printStackTrace();
		}
		finally
		{
			try 
			{
				if(rs!=null) 	rs.close();
				if(con!=null)	con.close();
			} 
			catch (SQLException e) 
			{
			e.printStackTrace();
			}
		}
		return flag;
	}

	@Override
	public boolean changePassword(String userid) {
		
		return false;
	}

	@Override
	public boolean forgotPassword(String userid) {
		
		return false;
	}

	@Override
	public boolean updateUser(Users u) {
		return false;
	}

	@Override
	public String getName(Users u) 
	{
		Jdbcutil.loaddriver();
		Connection con = null;
		con = Jdbcutil.getConnection();
		ResultSet rs = null;
		PreparedStatement ps =null;
		

		String getname = "select login_name from user where user_id=?";
		try 
		{
			ps = con.prepareStatement(getname);
			ps.setString(1, u.getUserid());
			rs = ps.executeQuery();
			
			if(rs.next())
			{
				u.setName(rs.getString("login_name"));
			}
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return u.getName();
	}

}
