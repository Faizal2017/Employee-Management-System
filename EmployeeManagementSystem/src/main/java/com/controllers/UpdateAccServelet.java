package com.controllers;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.AccountDAO;
import com.model.Account_details;

/**
 * Servlet implementation class UpdateAccServelet
 */
@WebServlet("/UpdateAccServelet")
public class UpdateAccServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateAccServelet() {
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
		 
		AccountDAO update= new AccountDAO();
		ResultSet rs= null;
		rs = update.Get_Details(value, value1);
		
		try {
			if (!rs.next() ) {
			    System.out.println("no data");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		request.setAttribute("rs", rs); 
		request.getRequestDispatcher("/Update_acc.jsp").forward(request, response);
		
		 
		 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String employeeID = request.getParameter("Emp_ID");
		String AccountNO =  request.getParameter("acc_no");
		String Bank = request.getParameter("bank");
		String Branch = request.getParameter("branch");
		String OldAcc= request.getParameter("old_acc");
		
		Account_details account= new Account_details();
		
		account.setEmp_id(employeeID);
		account.setAccount_no(AccountNO);
		account.setBank(Bank);
		account.setBranch(Branch);
		
		
		AccountDAO update= new AccountDAO();
		
		String log = update.UpdateAccount(account, OldAcc);
		
		if(log.equals("SUCCESS")) {
			
			request.setAttribute("name1", "value1");
			request.getRequestDispatcher("/Acc_details.jsp").forward(request, response);
		}
		else {
			
			System.out.println("Error in update Account");
		}
	}

}
