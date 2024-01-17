package com.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.DepartmentDAO;

/**
 * Servlet implementation class DeleteDepServlet
 */
@WebServlet("/DeleteDepServlet")
public class DeleteDepServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteDepServlet() {
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
		 String value = request.getParameter("depID");
		 
		 //create DepartmentDAO class and call Delete_dep method
		 DepartmentDAO delete= new DepartmentDAO();
		 
		 String log = delete.Delete_dep(value); 
		 
		 if(log.equals("SUCCESS")) {
				
				request.getRequestDispatcher("/DepDetails.jsp").forward(request, response);
			}
		 else {
				
				System.out.println("Error in delete department");
			}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
