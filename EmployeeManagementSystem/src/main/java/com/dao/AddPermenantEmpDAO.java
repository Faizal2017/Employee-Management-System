package com.dao;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.db.util.DBConnection;
import com.model.permenantEmployee;





public class AddPermenantEmpDAO {
	
	public String AddPermenantEmp(permenantEmployee emp) {
		
		//Assigning values to variables using getters

		
		String dob = emp.getDob();
		String name = emp.getName();
	    String gender = emp.getGender();
		String address = emp.getAddress();
		String phone = emp.getPhone();
		String email = emp.getEmail();
		String department =emp.getDepartment();
		String position = emp.getPosition();
		Double salary = emp.getSalary();
		

		Connection con = null;
		PreparedStatement stmt = null;
		
		
  try {
			
	        DBConnection DBcon =DBConnection.getInstance();
		
		    con = DBcon.createconnection();
			
		    //SQL Query
			String query = "insert into permenant_employee (Name, DOB, Gender, Phone, Email, Address, Department, Position, Salary) values ( ?, ? , ? , ? , ? , ? , ? , ? ,? )";
			
			stmt = con.prepareStatement(query);
			
			
			//Passing values to relevant ? in the query
			
			stmt.setString(1, name);
			stmt.setString(2, dob);
			stmt.setString(3, gender);
			stmt.setString(4, phone);
			stmt.setString(5, email);
			stmt.setString(6, address);
			stmt.setString(7, department);
			stmt.setString(8, position);
			stmt.setDouble(9, salary);
			
    int i = stmt.executeUpdate();
			
			if (i!=0)
				return "SUCCESS";
		
	 }
  catch (SQLException e) {
		
		e.printStackTrace();
	}
	
	return "Oops.. Something went wrong there..!" ;
}
      
    	  
    	  
    	  
    	  
      
}
