package com.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




import com.dao.updateEmployeeDAO;

import com.model.permenantEmployee;
import com.model.temporaryEmployee;


@WebServlet(name = "updateEmployeeServlet", urlPatterns = { "/updateEmployeeServlet" })
public class updateEmployeeServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	public updateEmployeeServlet() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 // obtaining values from EditPermenantEmp.jsp or EditTemporaryEmp.jsp  and assigning it to  variables

		 String id = request.getParameter("id");
		 String name = request.getParameter("name");
	     String address = request.getParameter("address");
	     String email = request.getParameter("email");
	     String phone = request.getParameter("phone");
	     String department = request.getParameter("department");
	     String position = request.getParameter("position");
	  
		
		 //if employee is permanent employee
	     
	     if(id.charAt(0)=='P') {
	    	 
	 	 //create object of permenantEmployee class
	     permenantEmployee emp = new permenantEmployee();
	     
	     
	     //Assigning values using setter
	     emp.setId(id);
	     emp.setEmail(email);
	     emp.setName(name);
	     emp.setAddress(address);
	     emp.setDepartment(department);
         emp.setPosition(position);
         emp.setPhone(phone);
         
		//create object updateEmployeeDAO 
        updateEmployeeDAO EmpDAO = new updateEmployeeDAO();
		
		String x = EmpDAO.UpdateEMP(emp);
		
		if(x.equals("SUCCESS")) {
			
			System.out.println("your record updatation suuccessfully");
			request.setAttribute("name1", "value");
			
			request.getRequestDispatcher("/DisplayPermenantEmp.jsp").forward(request, response);
		}
		else {
			
			request.setAttribute("errMessage", x);

	        request.getRequestDispatcher("/Login.jsp").forward(request, response);
		}
	     }
	     
	     //if employee is a temporary Employee
	     
	     else if(id.charAt(0)=='T') {
	    	 
	 		//create object temporaryEmployee 

	    	 temporaryEmployee emp = new temporaryEmployee();
	 	     
	    	 
	    	//Assigning values using setter
	 	     emp.setId(id);
	 	     emp.setName(name);
	 	     emp.setAddress(address);
	 	     emp.setDepartment(department);
	         emp.setPosition(position);
	         emp.setPhone(phone);
	          
	 		//create object updateEmployeeDAO 
	 		
	        updateEmployeeDAO EmpDAO = new updateEmployeeDAO();
	 		
	 		String x = EmpDAO.UpdateTempEmp(emp);
	 		
	 		if(x.equals("SUCCESS")) {
	 			
	 			System.out.println("your record updatation suuccessfully");
	 			request.setAttribute("name1", "value");
	 			
	 			request.getRequestDispatcher("/DisplayTempEmp.jsp").forward(request, response);
	 		}
	 		else {
	 			
	 			request.setAttribute("errMessage", x);

	 	        request.getRequestDispatcher("/Login.jsp").forward(request, response);
	 		}
	    	 
	    	 
	    	 
	     }
		
	}

}

