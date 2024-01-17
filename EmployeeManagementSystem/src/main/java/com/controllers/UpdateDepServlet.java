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
 * Servlet implementation class UpdateDepServlet
 */
@WebServlet("/UpdateDepServlet")
public class UpdateDepServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateDepServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		// Declare variables 
		String depID = request.getParameter("depID");
		String depName = request.getParameter("depName");
		
		// to pass value to UpdateDep.jsp
		request.setAttribute("depID", depID); 
		request.setAttribute("depName", depName); 
		request.getRequestDispatcher("/UpdateDep.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		String depID = request.getParameter("depID");
		String depName =  request.getParameter("depName");
		
		DepartmentDetails department= new DepartmentDetails();
		
		department.setDepartmentID(depID);
		department.setDepartmentName(depName);

		DepartmentDAO update= new DepartmentDAO();
		
		String log = update.UpdateDepartment(department);
		
		System.out.println(log);
		
		if(log.equals("SUCCESS")) {
			
			request.getRequestDispatcher("/DepDetails.jsp").forward(request, response);
		}
		else {
			
			System.out.println("Error in update department");
		}
		
	}

}
