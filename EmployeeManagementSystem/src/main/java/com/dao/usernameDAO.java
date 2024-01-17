


package com.dao;
import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import com.db.util.DBConnection;
import com.model.username;






public class usernameDAO {
	
	public String Addusername(username emp) {
		
		String id = emp.getEmpid();
		String name = emp.getUsername();
		String password = emp.getPassword();
		
		
		Connection con = null;
		PreparedStatement stmt = null;
		
		
  try {
			
	  DBConnection DBcon =DBConnection.getInstance();
		
		con = DBcon.createconnection();
			
	  String query = "insert into user_logins values(?,?,?)";
			
			stmt = con.prepareStatement(query);
			
			stmt.setString(1, id);
			stmt.setString(2,name);
			stmt.setString(3, password);
						
    int i = stmt.executeUpdate();
			
			if (i!=0)
				return "SUCCESS";
		
	 }
  catch (SQLException e) {
		
		e.printStackTrace();
	}
	
	return "Oops.. Something went wrong there..!" ;
}
	
	
	public static String DeleteUser(String EmpID) {
		  Connection con = null;
		  Statement stmt = null;
		  
		  try {
		       
			  DBConnection DBcon =DBConnection.getInstance();
				
				con = DBcon.createconnection();

		        stmt = con.createStatement();

		        int i = stmt.executeUpdate("DELETE FROM user_logins WHERE EmpId='" + EmpID+"'");
				
				if (i!=0)
					return "SUCCESS";

		        con.close();
		    }
		    catch(Exception e){
		        e.printStackTrace();
		    }
		  
		  return "Oops.. Something went wrong there..!";
		}
      
    	  
    	  
    	  
    	  
      
}


