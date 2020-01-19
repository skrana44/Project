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

@WebServlet("/PetActionPurchaseHistory")
public class PetActionPurchaseHistory extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public PetActionPurchaseHistory() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
			{
		HttpSession session = request.getSession(false);
		PetService pservice = new PetService();
		ArrayList<Pets> l1 = pservice.history((String)session.getAttribute("userid"));
		request.setAttribute("plist",l1);
		if(l1.size()>0)
		{
		RequestDispatcher rd = request.getRequestDispatcher("purchase_history.jsp");
		rd.forward(request, response);
		}
		else
		{
			request.setAttribute("emptylist", "No pets purchased till now");
			RequestDispatcher rd = request.getRequestDispatcher("pet_Welcome.jsp");
			rd.forward(request, response);
			
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
			{

		
	}

}
