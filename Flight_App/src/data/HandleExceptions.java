package data;

import java.sql.*;

import database.Database;
import javafx.scene.control.Alert;

public class HandleExceptions {
	
	Database d;
	Alerts a;
	Data data;
	
	
	public void checkExceptions(Object obj) {
		
		try {
			System.out.println("In the check section");
			d = new Database();
			d.addUser((data));
			d.closeConnection();
		}
		
		catch(SQLIntegrityConstraintViolationException ex) {
			a = new Alerts();
			String error = ex.getMessage();
			a.alert1(error);
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
	public Database getD() {
		return d;
	}
	public void setD(Database d) {
		this.d = d;
	}
	
	public void setData(Data a) {
		data = a;
		
		checkExceptions(data);
		
	}

}