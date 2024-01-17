


package com.dao;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.db.util.DBConnection;
import com.model.Training;






public class AddTrainingDAO {
	
	public String AddTrainingEmp(Training emp) {
		
		String TID = emp.getTrainingId();
		String name = emp.getTrainingName();
		String Desc = emp.getTrainingDescription();
		
		
		Connection con = null;
		PreparedStatement stmt = null;
		
		
  try {
			
	  DBConnection DBcon =DBConnection.getInstance();
		
		con = DBcon.createconnection();
			
	  String query = "insert into etraining values(?,?,?)";
			
			stmt = con.prepareStatement(query);
			
			stmt.setString(1, TID);
			stmt.setString(2,name);
			stmt.setString(3, Desc);
						
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

