package data;

import java.sql.Connection;
import database.Database;
import userInterface.Alerts;

public class Logic {
	 
	 Alerts a;
	 
	
	
	
	
	public static void getData(Data example, String msg) throws Exception {
		
		
		if(msg == "sign up")
			addUser(example);
		
		else if(msg == "login")
			login(example);
		
	}
	

	private static void login(Data example) throws Exception{
		
		Connection con = Database.connectToDatabase();
		Database.login(example);
		con.close();
		
	}

	public static  void addUser(Data data) throws Exception{
		
		Connection con = Database.connectToDatabase();
		Database.addUser(data);
		con.close();
		throw new customException("User Created");
	}


}
