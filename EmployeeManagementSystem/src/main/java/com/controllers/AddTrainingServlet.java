package com.controllers;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.dao.AddTrainingDAO;
import com.model.Training;



@WebServlet(name = "AddTrainingServlet", urlPatterns = { "/AddTrainingServlet" })
public class AddTrainingServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	public AddTrainingServlet() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String desc = request.getParameter("description");
		
		//create object of Addemployee class
	     
		Training emp = new Training();
	    
         emp.setTrainingId(id);
         emp.setTrainingName(name);
         emp.setTrainingDescription(desc);
	    
        
         AddTrainingDAO EmpDAO = new AddTrainingDAO();
		
		String x = EmpDAO.AddTrainingEmp(emp);
		
		if(x.equals("SUCCESS")) {
			
			//request.getRequestDispatcher("/Login.jsp").forward(request, response);
			System.out.println("your record inserted suuccessfully");
			 request.setAttribute("successMessage", "Your record has been inserted successfully.");
			request.getRequestDispatcher("/DisplayTraining.jsp").forward(request, response);
		}
		else {
			
			request.setAttribute("errMessage", x);

	        request.getRequestDispatcher("/Login.jsp").forward(request, response);
		}
		
	}

}

