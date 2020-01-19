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

@WebServlet("/PetActionSearch")
public class PetActionSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public PetActionSearch() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
			{}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
			{
		RequestDispatcher  rd = null;
		String msg = "";
		Pets p = new Pets();
		PetService pservice = new PetService();
		HttpSession session = request.getSession(false);
		session.getAttribute("name");

		p.setPet_type(request.getParameter("ptype"));
		p.setPet_name(request.getParameter("pname").trim());
		
		if(request.getParameter("page")!=null &&  request.getParameter("page")!="" )
		p.setPet_age(Integer.parseInt(request.getParameter("page").trim()));
		
		p.setPet_place(request.getParameter("pplace").trim());
		p.setPet_size(request.getParameter("psize"));
		
		
		
		
		ArrayList<Pets> list3 = pservice.search_Pets(p);
		if(list3.size()>0)
		{
		request.setAttribute("list1",list3);
		rd = request.getRequestDispatcher("search_resultsbuy.jsp");
		rd.forward(request, response);
		}
		else
		{
		msg = "No record found based on your search criteria";
		request.setAttribute("norecord", msg);
	    rd = request.getRequestDispatcher("search_pet.jsp");
		rd.forward(request, response);
		}
			
    
      }
}


