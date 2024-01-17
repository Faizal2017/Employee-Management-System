package com.controllers;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.AccountDAO;
import com.dao.GetDAO;
import com.dao.PermenantPayDAO;
import com.dao.TemporaryPayDAO;

/**
 * Servlet implementation class MakePaymentServelet
 */
@WebServlet("/MakePaymentServelet")
public class MakePaymentServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MakePaymentServelet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		String value = request.getParameter("empID");
		ResultSet rs =null;
		ResultSet rs1 =null;
		ResultSet rs2 =null;
		ResultSet rs3 =null;
		int leave = 0;
		int extraleave=0;
		
		if(value.toUpperCase().trim().startsWith("P")) {
			PermenantPayDAO pay= new PermenantPayDAO();
			rs= pay.getPaymentDetails(value);
		}
		 
		if(value.toUpperCase().trim().startsWith("T")) {
			TemporaryPayDAO pay= new TemporaryPayDAO();
			rs= pay.getPaymentDetails(value);
		}
		
		AccountDAO acc= new AccountDAO();
		rs1=acc.PayAcc(value);
		
		rs2=GetDAO.getMonth(value);
		
		rs3=GetDAO.getLeave(value);
		
		try {
			while(rs3.next()){
				   leave= rs3.getInt(1);   
				}
		} catch (SQLException e) {
			e.printStackTrace();
			
			System.out.println("No leave found");
		}
		
		if(leave<0) {
			extraleave= Math.abs(leave);
		}
		else { 
			extraleave =0;
		}
		
		
		request.setAttribute("rs", rs); 
		request.setAttribute("rs1", rs1); 
		request.setAttribute("rs2", rs2); 
		request.setAttribute("extraleave", extraleave); 
		request.getRequestDispatcher("/PayEmpDetails.jsp").forward(request, response);
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
		String acc = request.getParameter("acc");
		double percentage=0;
		double netSalary=0;
		
		
		if(employeeID.toUpperCase().trim().startsWith("P")) {
			PermenantPayDAO pay= new PermenantPayDAO();
			netSalary= pay.calculateSalary(Salary, Leave, Bonus);
			percentage=2.5;
		}
		 
		if(employeeID.toUpperCase().trim().startsWith("T")) {
			TemporaryPayDAO pay= new TemporaryPayDAO();
			netSalary= pay.calculateSalary(Salary, Leave, Bonus);
			percentage=3.5;
		}
		
		ArrayList<Comparable> arr= new ArrayList<Comparable>();

		arr.add(employeeID);
		arr.add(Salary);
		arr.add(Month);
		arr.add(Leave);
		arr.add(Bonus);
		arr.add(acc);
		arr.add(percentage);
		arr.add(netSalary);
		
		request.setAttribute("arr", arr);
		
		request.getRequestDispatcher("/ConfirmPayment.jsp").forward(request, response);
	}

}
