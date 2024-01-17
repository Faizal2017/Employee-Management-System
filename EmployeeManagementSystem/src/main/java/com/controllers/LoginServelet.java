package com.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.LoginDAO;
import com.model.Login;

@WebServlet(name = "LoginServelet", urlPatterns = { "/LoginServelet" })
public class LoginServelet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	public LoginServelet() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("Email");
		String Password = request.getParameter("Password");
		
		Login login = new Login();
		
		if(email.equals("Admin") && Password.equals("Admin123")){
			System.out.println("login success");
			request.setAttribute("name4", "value");
			request.getRequestDispatcher("/DisplayPermenantEmp.jsp").forward(request, response);
		}
		
		
		login.setEmail(email);
		login.setPassword(Password);
		
		LoginDAO loginDao = new LoginDAO();
		
		String log = loginDao.LoginUser(login);
		
		System.out.println(log);
		
		
		if(log.charAt(0) == 'P') {
			System.out.println("login success");
			request.setAttribute("name", "value");
			request.setAttribute("eid", log);
			request.getRequestDispatcher("/EmployeeUI_PersonalInfo.jsp").forward(request, response);
		}
		else if(log.charAt(0) == 'T') {
			System.out.println("login success");
			request.setAttribute("name", "value");
			request.setAttribute("eid", log);
			request.getRequestDispatcher("/TempEmployeeUI_PersonalInfo.jsp").forward(request, response);
		}
		else {
			request.setAttribute("name1", "value");
	        request.getRequestDispatcher("/index.jsp").forward(request, response);
		}
		
	}

}

