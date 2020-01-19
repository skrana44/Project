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

@WebServlet("/PetActionSearchAll")
public class PetActionSearchAll extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public PetActionSearchAll() {}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
			{
		PetService pservice = new PetService();
		RequestDispatcher rd = null;
		String msg = "";
		HttpSession session = request.getSession(false);
		session.getAttribute("name");
		
		ArrayList<Pets> list3 = pservice.show_all((String)session.getAttribute("userid"));

		request.setAttribute("list1",list3);
		if(list3.size()>0)
		{
		request.setAttribute("list1",list3);
		rd = request.getRequestDispatcher("search_resultsbuy.jsp");
		rd.forward(request, response);
		}
		else
		{
		msg = "No Pets Available in database to buy";
		request.setAttribute("norecord", msg);
	    rd = request.getRequestDispatcher("pet_Welcome.jsp");
		rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
			{}

}
