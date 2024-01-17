package com.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.TrainingDAO;

/**
 * Servlet implementation class RemoveTrainingServlet
 */
@WebServlet("/RemoveTrainingServlet")
public class RemoveTrainingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveTrainingServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String value = request.getParameter("Id");
		 
		
		 String log = TrainingDAO.RemoveTraining(value);
		 
		 if(log.equals("SUCCESS")) {
				
				request.getRequestDispatcher("/TrainingDetails.jsp").forward(request, response);
			}
		 else {
				
				System.out.println("Error in remove training");
				request.getRequestDispatcher("/TrainingDetails.jsp").forward(request, response);
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
