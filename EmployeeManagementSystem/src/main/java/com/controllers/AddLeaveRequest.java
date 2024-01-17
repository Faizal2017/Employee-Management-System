package com.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.LeaveRequestDAO;
import com.model.Leave;


@WebServlet("/AddLeaveRequest")
public class AddLeaveRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public AddLeaveRequest() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Declare variables 
		String EmpID = request.getParameter("EmpID");
		String Reason = request.getParameter("Reason");
		String Description = request.getParameter("Des");
		String From = request.getParameter("From");
		int days = Integer.parseInt(request.getParameter("days"));
		
		// Create object with overloaded constructor and assign values to parameter
		Leave leave = new Leave(EmpID , Reason , Description , From , days);
		
		String log =LeaveRequestDAO.AddLeaveReq(leave);
		
		
		if(log.equals("SUCCESS")) {
			
			if(EmpID.charAt(0) =='P') {
				request.setAttribute("name", "value");
				request.getRequestDispatcher("/LeaveR.jsp?empID="+EmpID+"").forward(request, response);
				
			}
			if(EmpID.charAt(0) == 'T') {
				request.setAttribute("name", "value");
				request.getRequestDispatcher("/TempLeaveR.jsp?empID="+EmpID+"").forward(request, response);
				
			}

		}
		else {
			
			request.setAttribute("errMessage", log);

	        request.getRequestDispatcher("/").forward(request, response);
		}
		
	}

}