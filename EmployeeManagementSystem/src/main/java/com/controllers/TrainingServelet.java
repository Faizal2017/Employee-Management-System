package com.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.TrainingDAO;

/**
 * Servlet implementation class TrainingServelet
 */
@WebServlet("/TrainingServelet")
public class TrainingServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TrainingServelet() {
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
		
		String employeeID = request.getParameter("Emp_ID");
		String Training =  request.getParameter("tname");
		
		String log= TrainingDAO.AssignTraining(employeeID, Training);
		
		if(log.equals("SUCCESS")) {
			
			request.getRequestDispatcher("/TrainingDetails.jsp").forward(request, response);
		}
		else {
			
			System.out.println("Error in assign training");
		}
		
		
	}

}
