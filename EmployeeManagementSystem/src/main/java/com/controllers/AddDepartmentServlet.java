package com.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.DepartmentDAO;
import com.model.DepartmentDetails;

/**
 * Servlet implementation class AddDepartmentServlet
 */
@WebServlet("/AddDepartmentServlet")
public class AddDepartmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddDepartmentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Declare variables 
		String departmentID = request.getParameter("depID");
		String departmentName =  request.getParameter("depName");
		
		// create DepartmentDetails object and set values
		DepartmentDetails department= new DepartmentDetails();
		
		department.setDepartmentID(departmentID);
		department.setDepartmentName(departmentName);
		
		//create DepartmentDAO object and call AddDepartment method with parameter
		DepartmentDAO depDao = new DepartmentDAO();
		
		String log = depDao.AddDepartment(department);
		
		
		if(log.equals("SUCCESS")) {
			
			request.getRequestDispatcher("/DepDetails.jsp").forward(request, response);
		}
		else {
			
			System.out.println("Error in add department");
		}
		
	}

}
