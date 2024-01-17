package com.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;





import com.dao.usernameDAO;
import com.model.Training;
import com.model.username;



@WebServlet(name = "usernameServlet", urlPatterns = { "/usernameServlet" })
public class usernameServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	public usernameServlet() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String id = request.getParameter("idd");
		String username = request.getParameter("name");
		String password = request.getParameter("password");
		
		//create object of Addemployee class
	     
		username emp = new username();
	    
         emp.setUsername(username);
         emp.setEmpid(id);
         emp.setPassword(password);
	    
        
         usernameDAO EmpDAO = new usernameDAO();
		
		String x = EmpDAO.Addusername(emp);
		
		if(x.equals("SUCCESS")) {
			
			//request.getRequestDispatcher("/Login.jsp").forward(request, response);
			System.out.println("your record inserted suuccessfully");
			 request.setAttribute("successMessage", "Your record has been inserted successfully.");
			request.getRequestDispatcher("/User.jsp").forward(request, response);
		}
		else {
			
			request.setAttribute("errMessage", x);

	        request.getRequestDispatcher("/Login.jsp").forward(request, response);
		}
		
	}

}

