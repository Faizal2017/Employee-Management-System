package com.dao;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.db.util.DBConnection;
import com.model.Training;






public class updateTrainingDAO {
	
	public String updateTraining(Training emp) {
		
		String  id= emp.getTrainingId();
		String desc = emp.getTrainingDescription();
		String name = emp.getTrainingName();
	    
		

		Connection con = null;
		PreparedStatement stmt = null;
		
		
  try {
			
	  DBConnection DBcon =DBConnection.getInstance();
		
		con = DBcon.createconnection();
			
			String query = "update etraining set Name = ? , Description = ? where TrainingID = ?;";
			
			stmt = con.prepareStatement(query);
			
			stmt.setString(3, id);
			stmt.setString(2,desc);
			stmt.setString(1, name);
			
			
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
