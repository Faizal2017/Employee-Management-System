package com.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.LeaveRequestDAO;

/**
 * Servlet implementation class DeleteLeaveRequestServlet
 */
@WebServlet("/DeleteLeaveRequestServlet")
public class DeleteLeaveRequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteLeaveRequestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Declare variables 
		String value = request.getParameter("Id");
		String value1 = request.getParameter("empid");
		
		// call static method DeleteLeaveRequest from LeaveRequestDAO
		 String log = LeaveRequestDAO.DeleteLeaveRequest(value);
		 
		 if(log.equals("SUCCESS")) {
		 if(value1.charAt(0) == 'P') {
			 request.setAttribute("name5", "value"); // to pass value to jsp
				request.getRequestDispatcher("/LeaveR.jsp?empID="+value1+"").forward(request, response);
			}
		 if(value1.charAt(0) == 'T') {
			 request.setAttribute("name5", "value"); // to pass value to jsp
				request.getRequestDispatcher("/TempLeaveR.jsp?empID="+value1+"").forward(request, response);
			}
		 }
		 else {
				
				System.out.println("Error in remove training");
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
