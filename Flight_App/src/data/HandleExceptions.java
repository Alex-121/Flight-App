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
			System.out.println("figured it out");
			//throw this back up so app can display alert about ssn duplication
			throw new SQLIntegrityConstraintViolationException("SSN error");
		} 
		catch(customException ex) {
			
			if(ex.getMessage() == "User name not found. Please sign up")
				Alerts.alert1(ex.getMessage());
			throw ex ;
		}
		
		catch(Exception ex) {
			ex.printStackTrace();
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