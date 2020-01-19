package com.hcl.jsh.actions;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hcl.jsh.model.Users;

@WebServlet("/UserActionSignup")
public class UserActionSignup extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public UserActionSignup() {}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		UserService userS=new UserService();
		Users u = new Users();
		
		String msg = "";
		u.setUserid(request.getParameter("userid"));
		u.setName(request.getParameter("name"));
		u.setPassword(request.getParameter("password"));
		
	
		if(userS.createUser(u) != null)
		{
		msg = "Registration Success";
		request.setAttribute("message", msg);
		RequestDispatcher rd = request.getRequestDispatcher("pet_login.jsp");
		rd.forward(request, response);
		}
		else
			{
			msg = "Userid already exists";
			request.setAttribute("message", msg);
			RequestDispatcher rd = request.getRequestDispatcher("pet_login.jsp");
			rd.include(request, response);
			}
		
	}

}
