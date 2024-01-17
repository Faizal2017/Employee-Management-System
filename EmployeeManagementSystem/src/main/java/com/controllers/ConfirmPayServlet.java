package com.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.PermenantPayDAO;
import com.dao.TemporaryPayDAO;
import com.model.PaymentDetails;

/**
 * Servlet implementation class ConfirmPayServlet
 */
@WebServlet("/ConfirmPayServlet")
public class ConfirmPayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConfirmPayServlet() {
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
		double Salary =  Double.parseDouble(request.getParameter("salary"));
		String Month = request.getParameter("month");
		int Leave = Integer.parseInt(request.getParameter("leave"));
		int Bonus= Integer.parseInt(request.getParameter("bonus"));
		Double netSalary =  Double.parseDouble(request.getParameter("netSal"));
		String account = request.getParameter("acc");
		String log= null;
		
		PaymentDetails pay= new PaymentDetails();		
		
		pay.setEmpId(employeeID);
		pay.setSalary(Salary);
		pay.setMonth(Month);
		pay.setLeave(Leave);
		pay.setBonus(Bonus);
		pay.setNetSalary(netSalary);
		pay.setAccount(account);
		
		if(employeeID.toUpperCase().trim().startsWith("P")) {
			PermenantPayDAO npay= new PermenantPayDAO();
			log= npay.AddPayment(pay);
		}
		
		if(employeeID.toUpperCase().trim().startsWith("T")) {
			TemporaryPayDAO npay= new TemporaryPayDAO();
			log= npay.AddPayment(pay);
		}
		
		if(log.equals("SUCCESS")) {
			
			request.getRequestDispatcher("/PayEmployee.jsp").forward(request, response);
		}
		else {
			
			System.out.println("Error");
		}
		
		
		
	}

}
