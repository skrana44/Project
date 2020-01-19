package com.hcl.jsh.actions;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/UserActionLogout")
public class UserActionLogout extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public UserActionLogout() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
			{
		HttpSession session = request.getSession(false);
		session.removeAttribute("name");
		session.removeAttribute("userid");
		session.invalidate();
		RequestDispatcher rd = request.getRequestDispatcher("pet_login.jsp");
		rd.include(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
			{}

}
