package data;

import database.Database;
import userInterface.Alerts;

public class Logic {
	 Database d;
	 Alerts a;
	 Data data;
	
	
	
	
	public void getData(Data example, String msg) throws Exception {
		data = example;
		
		if(msg == "sign up")
			addUser(example);
		
		else if(msg == "login")
			login(example);
	}
	
	private void login(Data example) throws Exception{
		
		d = new Database();
		d.login(example);
		Database.closeConnection();
		
	}

	public  void addUser(Data data) throws Exception{
		
		d = new Database();
		d.addUser(data);
		Database.closeConnection();
		throw new customException("User Created");
	}


}
