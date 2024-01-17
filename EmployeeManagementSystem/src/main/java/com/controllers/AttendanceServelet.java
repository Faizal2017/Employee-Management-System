package com.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.AttendanceDAO;
import com.model.Attendance;


@WebServlet("/AttendanceServelet")
public class AttendanceServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public AttendanceServelet() {
        super();
        
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// create array to store multiple data
		String[] Emp = request.getParameterValues("Empid[]");
		String[] Status = request.getParameterValues("Status[]");
		
		// create Attendance object and set values
		Attendance attendence = new Attendance();
		
		attendence.setEmp(Emp);
		attendence.setStatus(Status);
		
		// Calling Static method name insertAttendence from AttendanceDAO class
		String log = AttendanceDAO.insertAttendence(attendence);
		
		
		if(log.equals("SUCCESS")) {
			request.setAttribute("name", "value"); // to pass value to jsp
			request.getRequestDispatcher("/AttendenceAdmin.jsp").forward(request, response);
		}
		else {
			
			request.setAttribute("errMessage", log);

	        request.getRequestDispatcher("/AttendenceAdmin.jsp").forward(request, response);
		}
		
	}

}