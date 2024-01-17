package com.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.PermenantPayDAO;
import com.dao.TemporaryPayDAO;

/**
 * Servlet implementation class UpdateSalaryServlet
 */
@WebServlet("/UpdateSalaryServlet")
public class UpdateSalaryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateSalaryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String empID = request.getParameter("empID");
		double salary =  Double.parseDouble(request.getParameter("salary"));
		
		request.setAttribute("empID", empID); 
		request.setAttribute("salary", salary); 
		request.getRequestDispatcher("/UpdateSalary.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String empID = request.getParameter("empID");
		double salary =  Double.parseDouble(request.getParameter("salary"));
		String log= null;
		
		if(empID.toUpperCase().trim().startsWith("P")) {
			log=  PermenantPayDAO.updateSalary(empID, salary);
		}
		 
		if(empID.toUpperCase().trim().startsWith("T")) {
			log= TemporaryPayDAO.updateSalary(empID, salary);
		}
		
		if(log.equals("SUCCESS")) {
			
			request.getRequestDispatcher("/SalaryDetails.jsp").forward(request, response);
		}
		else {
			
			System.out.println("Error in update salary");
		}
	}

}
