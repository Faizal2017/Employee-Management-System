package com.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.ApproveDenyLRDAO;

@WebServlet("/ApproveLRServelet")
public class ApproveLRServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ApproveLRServelet() {
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
		String reqid = request.getParameter("RqID");
		
		// Calling Static method name Approve from ApproveDenyLRDAO class
		String log =ApproveDenyLRDAO.Approve(reqid);
		
		if(log.equals("SUCCESS")) {
			
			request.getRequestDispatcher("/LeaveRAdmin.jsp").forward(request, response);
		}
		else {
			
			request.setAttribute("errMessage", log);

	        request.getRequestDispatcher("/LeaveRAdmin.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
	}

}
