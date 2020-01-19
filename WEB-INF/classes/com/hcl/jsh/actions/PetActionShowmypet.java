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

@WebServlet("/PetActionShowmypet")
public class PetActionShowmypet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public PetActionShowmypet() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String msg = "";
		HttpSession session = request.getSession(false);
		RequestDispatcher rd = null;
		PetService pservice = new PetService();
		ArrayList<Pets> l1 = pservice.my_Pet((String)session.getAttribute("userid"));
	
		request.setAttribute("list1",l1);
		if(l1.size()>0)
		{
			rd = request.getRequestDispatcher("search_results.jsp");
			rd.forward(request, response);
		}
		else
		{
			msg = "No Pets added by you";
			request.setAttribute("nopets", msg);
			rd = request.getRequestDispatcher("pet_Welcome.jsp");
		 	rd.forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
			{


		// TODO Auto-generated method stub
	}

}
