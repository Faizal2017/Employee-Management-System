package com.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.LeaveRequestDAO;
import com.model.Leave;


@WebServlet("/TempAddLeaveRequest")
public class TempAddLeaveRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public TempAddLeaveRequest() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String EmpID = request.getParameter("EmpID");
		String Reason = request.getParameter("Reason");
		String Description = request.getParameter("Des");
		String From = request.getParameter("From");
		int days = Integer.parseInt(request.getParameter("days"));
		
		Leave leave = new Leave(EmpID , Reason , Description , From , days);
		
		String log =LeaveRequestDAO.AddLeaveReq(leave);
		
		
		if(log.equals("SUCCESS")) {
			
			request.getRequestDispatcher("/TempLeaveR.jsp?empID="+EmpID+"").forward(request, response);
		}
		else {
			
			request.setAttribute("errMessage", log);

	        request.getRequestDispatcher("/TempLeaveR.jsp").forward(request, response);
		}
		
	}

}