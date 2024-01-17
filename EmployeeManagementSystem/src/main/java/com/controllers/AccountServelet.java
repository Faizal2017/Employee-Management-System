package com.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.AccountDAO;
import com.model.Account_details;



/**
 * Servlet implementation class AccountServelet
 */
@WebServlet("/AccountServelet")
public class AccountServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccountServelet() {
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
		String AccountNO =  request.getParameter("acc_no");
		String Bank = request.getParameter("bank");
		String Branch = request.getParameter("branch");
		
		Account_details account= new Account_details(employeeID, AccountNO, Bank, Branch);
		
		AccountDAO accountDao = new AccountDAO();
		
		String log = accountDao.AddAccount(account);
		
		if(log.equals("SUCCESS")) {
			request.setAttribute("name", "value");
			request.getRequestDispatcher("/Acc_details.jsp").forward(request, response);
		}
		else {
			
			request.setAttribute("errMessage", log);

	        request.getRequestDispatcher("/Acc_details.jsp").forward(request, response);
		}
	}

}
