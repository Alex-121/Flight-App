package data;

import java.sql.*;

public class HandleExceptions extends Logic{
	


	
	public void checkExceptions(Data example, String msg) throws SQLIntegrityConstraintViolationException {
		Logic t = new Logic();
		
		try {

			t.getData(example, msg);
			
			
			
		}
		
		catch(SQLIntegrityConstraintViolationException ex) {
			System.out.println("figured it out");
			//throw this back up so app can display alert about ssn duplication
			throw new SQLIntegrityConstraintViolationException("SSN error");
		} 
		
		catch(Exception ex) {
			ex.printStackTrace();
		}
		finally {
			//must wrap the close in a try catch
			try {
				
			} catch (Exception e) {
				
				System.out.println("Error caught");;
			}
		}
		
	}

}