package com.dao;


import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.db.util.DBConnection;
import com.model.Training;





public class DeleteTrainingDAO {
	
	public String DeleteTraining(Training emp) {
		
		try {
			
			
			String id = emp.getTrainingId();
			
			Connection con = null;
			PreparedStatement stmt = null;
			
			
	  
				
			DBConnection DBcon =DBConnection.getInstance();
			
			con = DBcon.createconnection();
				
		  String query = "delete from etraining where TrainingID = ? ";

				
				stmt = con.prepareStatement(query);
				
				
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
