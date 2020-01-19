package com.hcl.jsh.actions;

import java.io.IOException;
import java.util.ArrayList;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.hcl.jsh.model.Pets;
import com.hcl.jsh.model.Users;


@WebServlet("/UserActionLogin")
public class UserActionLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public UserActionLogin() {}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
			{
		Users u = new Users();
		UserService service = new UserService();
		PetService pservice = new PetService();
		String msg = "";
		u.setUserid(request.getParameter("userid"));
		u.setPassword(request.getParameter("password"));
			


		if(service.validateLogin(u) != null)
		{  
			String name  = service.validateLogin(u);
			HttpSession session = request.getSession();
			session.setAttribute("name", name);
			session.setAttribute("userid",u.getUserid());
			ArrayList<Pets> pettypes = pservice.fetch_pets();
			session.setAttribute("types",pettypes);
			RequestDispatcher rd = request.getRequestDispatcher("pet_Welcome.jsp");
			rd.forward(request, response);
		}

		else
		{
			msg = "Invalid Username or Password";
			request.setAttribute("invalid", msg);
			RequestDispatcher rd = request.getRequestDispatcher("/pet_login.jsp");
			rd.include(request, response);
		}
	}

}
