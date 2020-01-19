package com.hcl.jsh.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Jdbcutil 
{
	public static String Driver="com.mysql.jdbc.Driver";
	public static String url="jdbc:mysql://localhost/new";
	public static String userid="root";
	public static String Password="Hello123";
	
	public static void loaddriver()
	{
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
		} 
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection()
	{
		Connection con=null;
		try 
		{
			con = DriverManager.getConnection(Jdbcutil.url,Jdbcutil.userid,Jdbcutil.Password);
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	
}
