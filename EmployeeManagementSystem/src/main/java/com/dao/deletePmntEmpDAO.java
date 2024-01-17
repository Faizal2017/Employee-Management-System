package com.dao;


import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.db.util.DBConnection;
import com.model.permenantEmployee;
import com.model.temporaryEmployee;





public class deletePmntEmpDAO {
	
	public String DeletePermenantEmp(permenantEmployee emp) {
		
		try {
			
			//Assigning Id using getter
			String id = emp.getId();
			
			Connection con = null;
			PreparedStatement stmt = null;
			
			
	  
				
			DBConnection DBcon =DBConnection.getInstance();
			
			con = DBcon.createconnection();
			
			//SQL Query
		    String query = "delete from permenant_employee where EmpId = ? ";

				
			stmt = con.prepareStatement(query);
			
			//Passing value to the ? in query
			stmt.setString(1, id);
			
            int i = stmt.executeUpdate();
			
		    if(i!=0)
				return "SUCCESS";
		
	 }
  catch (SQLException e) {
		
		e.printStackTrace();
	}
	
	return "Oops.. Something went wrong there..!" ;
}     

	public String DeleteTemporaryEmp(temporaryEmployee emp) {
		
		try {
			
			//Assigning Id using getter
			String id = emp.getId();
			
			Connection con = null;
			PreparedStatement stmt = null;
			
			
	  
				
			DBConnection DBcon =DBConnection.getInstance();
			
			con = DBcon.createconnection();
			
			//SQL Query	
		    String query = "delete from temporary_employee where EmpId = ? ";

				
		    stmt = con.prepareStatement(query);
		    
		  //Passing value to the ? in query		
			stmt.setString(1, id);
			
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

