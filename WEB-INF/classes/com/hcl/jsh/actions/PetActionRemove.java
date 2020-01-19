package com.hcl.jsh.actions;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/PetActionRemove")
public class PetActionRemove extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public PetActionRemove() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
			{
		HttpSession session = request.getSession(false);
		session.getAttribute("userid");
		String pet_id=request.getQueryString();
		PetService pservice = new PetService();
		if(pservice.remove(pet_id))
		
		{
		RequestDispatcher rd = request.getRequestDispatcher("/pet_Welcome.jsp");
		rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
	}

}
