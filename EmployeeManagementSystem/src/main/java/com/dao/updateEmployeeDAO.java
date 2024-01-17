package com.dao;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.db.util.DBConnection;

import com.model.permenantEmployee;
import com.model.temporaryEmployee;





public class updateEmployeeDAO {
	
	public String UpdateEMP(permenantEmployee emp) {
		
		//Assigning values to variables using getters

		String id = emp.getId();
		String name = emp.getName();
		String email = emp.getEmail();
		String address = emp.getAddress();
		String phone = emp.getPhone();
		String department =emp.getDepartment();
		String position = emp.getPosition();
		 
		

		Connection con = null;
		PreparedStatement stmt = null;
		
		
  try {
			
	        DBConnection DBcon =DBConnection.getInstance();
		
		    con = DBcon.createconnection();
			
		   //SQL query
			String query = "UPDATE permenant_employee set Name = ?  ,Address = ? , Phone = ?,Department =? ,Position =? ,Email = ? where EmpId =? ;";
			
			stmt = con.prepareStatement(query);
			
			//Passing values to relevant ? in the query
			
			stmt.setString(7, id);
			stmt.setString(6,email);
			stmt.setString(1, name);
			stmt.setString(2, address);
			stmt.setString(3, phone);
			stmt.setString(4, department);
			stmt.setString(5, position);
			
            int i = stmt.executeUpdate();
			
			if (i!=0)
				return "SUCCESS";
		
	 }
  catch (SQLException e) {
		
		e.printStackTrace();
	}
	
	return "Oops.. Something went wrong there..!" ;
}
	
public String UpdateTempEmp(temporaryEmployee emp) {
		
	
	    //Assigning values to variables using getters
	
		String id = emp.getId();
		String name = emp.getName();	
		String address = emp.getAddress();
		String phone = emp.getPhone();
		String department =emp.getDepartment();
		String position = emp.getPosition();
		 
		

		Connection con = null;
		PreparedStatement stmt = null;
		
		
  try {
			
	  DBConnection DBcon =DBConnection.getInstance();
		
		con = DBcon.createconnection();
			
		    //SQL Query
			String query = "UPDATE temporary_employee set Name = ?  ,Address = ? , Phone = ?,Department =? ,Position =? where EmpId =? ;";
			
			stmt = con.prepareStatement(query);
			
			//Passing values to relevant ? in the query
			stmt.setString(6, id);
			stmt.setString(1, name);
			stmt.setString(2, address);
			stmt.setString(3, phone);	
			stmt.setString(4, department);
			stmt.setString(5, position);
			
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
