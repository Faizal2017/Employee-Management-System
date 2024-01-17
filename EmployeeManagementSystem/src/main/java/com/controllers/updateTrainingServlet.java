package com.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;





import com.dao.updateTrainingDAO;
import com.model.Training;



@WebServlet(name = "updateTrainingServlet", urlPatterns = { "/updateTrainingServlet" })
public class updateTrainingServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	public updateTrainingServlet() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("idd");
		String name = request.getParameter("name");
		
	     String desc = request.getParameter("description");
	   
	  
		
	
	     Training tl= new Training();
	     
	     tl.setTrainingId(id);
	     tl.setTrainingName(name);;
	     tl.setTrainingDescription(desc);
	    
	    
         
		
		
         updateTrainingDAO  EmpDAO = new updateTrainingDAO();
		
		String x = EmpDAO.updateTraining(tl);
		
		if(x.equals("SUCCESS")) {
			
			//request.getRequestDispatcher("/Login.jsp").forward(request, response);
			System.out.println("your record updatation suuccessfully");
			request.setAttribute("successMessage", "Employee has been updated successfully.");
			
			request.getRequestDispatcher("/DisplayTraining.jsp").forward(request, response);
		}
		else {
			
			request.setAttribute("errMessage", x);

	        request.getRequestDispatcher("/Login.jsp").forward(request, response);
		}
	     }
	     
}
