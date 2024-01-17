package com.controllers;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.AccountDAO;

/**
 * Servlet implementation class DeleteAccServelet
 */
@WebServlet("/DeleteAccServelet")
public class DeleteAccServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteAccServelet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		 String value = request.getParameter("empID");
		 String value1= request.getParameter("accNo");
		 
		 AccountDAO delete= new AccountDAO();
		 
		 String log = delete.Delete_acc(value, value1);
		 
		 if(log.equals("SUCCESS")) {
			 request.setAttribute("name2", "value2");
				request.getRequestDispatcher("/Acc_details.jsp").forward(request, response);
			}
		 else {
				
				System.out.println("Error in delete account");
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
