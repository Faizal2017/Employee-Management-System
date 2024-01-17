package com.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




import com.model.permenantEmployee;
import com.model.temporaryEmployee;
import com.dao.deletePmntEmpDAO;


@WebServlet(name = "deleteEmployeeServlet", urlPatterns = { "/deleteEmployeeServlet" })
public class deleteEmployeeServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	public deleteEmployeeServlet() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 // obtaining EmpID and  assigning it to  variable

		String employeeID = request.getParameter("Id");
		
		
		//if the employee is permanent
		if(employeeID.charAt(0)=='P') {
		
	    //create object from permenantEmployee class	
		permenantEmployee emp = new permenantEmployee();
		
		//setting Id using setter
	    emp.setId(employeeID);
	
	   //create object from deletePmntEmpDAO class
       deletePmntEmpDAO EmpDAO = new deletePmntEmpDAO();
	
	   String x = EmpDAO.DeletePermenantEmp(emp);
	
	
	
	
	
	
	  if(x.equals("SUCCESS")) {
		
		request.setAttribute("name2", "value");
		request.getRequestDispatcher("/DisplayPermenantEmp.jsp").forward(request, response);
		System.out.println("your record deleted suuccessfully");
	}
	else {
		
		request.setAttribute("errMessage", x);

        request.getRequestDispatcher("/Login.jsp").forward(request, response);
	}
	

		
	}
		
		//if employee is temporary
		
		if(employeeID.charAt(0)=='T') {
			
			 //create object from temporaryEmployee class
			temporaryEmployee emp = new temporaryEmployee();
			
			//setting Id using setter
			emp.setId(employeeID);
			
			//create object from deletePmntEmpDAO class
		    deletePmntEmpDAO EmpDAO = new deletePmntEmpDAO();
			
			String x = EmpDAO.DeleteTemporaryEmp(emp);
			
			
			
			
			
			
			if(x.equals("SUCCESS")) {
				
				request.setAttribute("name2", "value");
				request.getRequestDispatcher("/DisplayTempEmp.jsp").forward(request, response);
				System.out.println("your record deleted suuccessfully");
			}
			else {
				
				request.setAttribute("errMessage", x);

		        request.getRequestDispatcher("/Login.jsp").forward(request, response);
			}
			
		}
		
		
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
				
	}

}

