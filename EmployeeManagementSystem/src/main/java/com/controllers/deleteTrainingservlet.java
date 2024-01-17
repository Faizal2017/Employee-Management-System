package com.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.Training;

import com.dao.DeleteTrainingDAO;



@WebServlet(name = "deleteTrainingservlet", urlPatterns = { "/deleteTrainingservlet" })
public class deleteTrainingservlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	public deleteTrainingservlet() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String ID = request.getParameter("Id");
		
		
		
		Training emp = new Training();
	emp.setTrainingId(ID);
	

	DeleteTrainingDAO EmpDAO = new DeleteTrainingDAO();
	
	String x = EmpDAO.DeleteTraining(emp);
	
	
	
	
	
	
	if(x.equals("SUCCESS")) {
		
		request.setAttribute("successMessage", "Employee has Deleted successfully.");
		request.getRequestDispatcher("/DisplayTraining.jsp").forward(request, response);
		System.out.println("your record deleted suuccessfully");
	}
	else {
		
		request.setAttribute("errMessage", x);

        request.getRequestDispatcher("/Login.jsp").forward(request, response);
	}
	}
}
	