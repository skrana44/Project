package com.hcl.jsh.actions;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hcl.jsh.model.Pets;

@WebServlet("/PetActionAdd")
public class PetActionAdd extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

    public PetActionAdd() {}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
			{
		
		Pets p = new Pets();
		PetService pservice = new PetService();
		HttpSession session = request.getSession(false);
		String userid = (String) session.getAttribute("userid");
		p.setPet_name(request.getParameter("pname"));
		try
		{
		p.setPet_age(Integer.parseInt(request.getParameter("page")));
		}
		catch(NumberFormatException e)
		{}
		p.setPet_place(request.getParameter("pplace"));
		
		p.setPet_type(request.getParameter("ptype"));
		p.setPet_size(request.getParameter("psize"));
		p.setPet_sex(request.getParameter("psex"));
		if(pservice.insert_pet(p, userid))
		{
			String msg = "Pet Added";
			request.setAttribute("added", msg);
			RequestDispatcher rd = request.getRequestDispatcher("/add_pet.jsp");
			rd.forward(request, response);
		}
		else
		{
			RequestDispatcher rd = request.getRequestDispatcher("/add_pet.jsp");
			rd.forward(request, response);
		}
		}
		
	}

