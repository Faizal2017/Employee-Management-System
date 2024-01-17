package com.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import com.dao.AddTemporaryEmpDAO;
import com.model.temporaryEmployee;


@WebServlet(name = "AddTempEmpServelet", urlPatterns = { "/AddTempEmpServelet" })
public class AddTempEmpServelet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	public AddTempEmpServelet() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 // obtaining values from AddTemporaryEmp.jsp and assigning it to  variables

		
		 String name = request.getParameter("name");
		 String dob= request.getParameter("age");
		 String gender = request.getParameter("gender");
	     String address = request.getParameter("address");
	     String email = request.getParameter("email");
	     String phone = request.getParameter("phone");
	     String department = request.getParameter("department");
	     String position = request.getParameter("position");
	     double salary = Double.parseDouble(request.getParameter("salary"));
	    		 
	     //create object from temporaryEmployee class
	     temporaryEmployee emp = new temporaryEmployee();
         emp.setName(name);
	     emp.setAddress(address);
	     emp.setDob(dob);
	     emp.setDepartment(department);
         emp.setEmail(email);
         emp.setGender(gender);
         emp.setPosition(position);
         emp.setPhone(phone);
         emp.setSalary(salary);
        
       //create object from AddTemporaryEmpDAO class
        AddTemporaryEmpDAO EmpDAO = new AddTemporaryEmpDAO();
		
		String x = EmpDAO.AddTemporaryEmp(emp);
		
		if(x.equals("SUCCESS")) {
			
			
			System.out.println("your record inserted suuccessfully");
			request.setAttribute("name", "value");
			request.getRequestDispatcher("/DisplayTempEmp.jsp").forward(request, response);
		}
		else {
			
			request.setAttribute("errMessage", x);

	        request.getRequestDispatcher("/Login.jsp").forward(request, response);
		}
		
	}

}

