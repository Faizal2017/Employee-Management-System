package com.dao;

import java.sql.Connection;
import java.sql.Statement;

import com.db.util.DBConnection;

public class TrainingDAO {

	public static String AssignTraining(String EmpID, String Training) {
		  Connection con = null;
		  Statement stmt = null;
		  
		  try {
		       
			  DBConnection DBcon =DBConnection.getInstance();
				
				con = DBcon.createconnection();

		        stmt = con.createStatement();

		        int i = stmt.executeUpdate("insert into assaign_training values ('"+EmpID+"','"+Training+"')");
				
				if (i!=0)
					return "SUCCESS";

		        con.close();
		    }
		    catch(Exception e){
		        e.printStackTrace();
		    }
		  
		  return "Oops.. Something went wrong there..!" ;
		}
	
	public static String RemoveTraining(String EmpID) {
		  Connection con = null;
		  Statement stmt = null;
		  
		  try {
		       
			  DBConnection DBcon =DBConnection.getInstance();
				
				con = DBcon.createconnection();

		        stmt = con.createStatement();

		        int i = stmt.executeUpdate("DELETE FROM assaign_training WHERE EmpId='" + EmpID+"'");
				
				if (i!=0)
					return "SUCCESS";

		        con.close();
		    }
		    catch(Exception e){
		        e.printStackTrace();
		    }
		  
		  return "Oops.. Something went wrong there..!" ;
		}
}
