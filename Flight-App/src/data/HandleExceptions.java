package data;

import java.sql.*;

import database.Database;
import userInterface.Alerts;

public class HandleExceptions {
	


	
	public static void checkExceptions(Data example, String msg) throws Exception {
		
		
		try {

			Logic.getData(example, msg);
			
			
			
		}
		
		catch(SQLIntegrityConstraintViolationException ex) {
			Alerts.alert1(ex.getMessage());;
		} 
		catch(customException ex) {
			
			if(ex.getMessage() == "User name not found. Please sign up")
				Alerts.alert1(ex.getMessage());
			throw ex ;
		}
		
		catch(Exception ex) {
			Alerts.alert1(ex.getMessage());
		}
		finally {
			
			
			
			try {
				Database.closeConnection();
				
			} catch (Exception e) {
				
				System.out.println("Error caught");;
			}
		}
		
	}

}