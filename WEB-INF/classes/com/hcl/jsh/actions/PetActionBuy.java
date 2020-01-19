package com.hcl.jsh.actions;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hcl.jsh.dao.PetsDAOImpl;

@WebServlet("/PetActionBuy")
public class PetActionBuy extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public PetActionBuy() { }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
			{
		String pet_id=request.getQueryString();
		HttpSession session = request.getSession(false);
		String userid  = (String) session.getAttribute("userid");
	
		PetsDAOImpl pdi = new PetsDAOImpl();
		PetService pservice = new PetService();
		pservice.pet_buy(pet_id, userid);
		pdi.buyPet(pet_id, userid);
		
		RequestDispatcher rd = request.getRequestDispatcher("pet_Welcome.jsp");
		rd.forward(request, response);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
	
	}

}
