package data;

import java.sql.Connection;

import java.sql.SQLException;


import database.Database;
import userInterface.Alerts;

public class Logic {
	 
	 Alerts a;
	 
	
	
	
	
	public static void getData(Data example, String msg) throws Exception {
		
		
		if(msg == "sign up")
			addUser(example);
		
		else if(msg == "login")
			login(example);

		else if(msg.equals("booking"))
			book(example);
		else if(msg.equals("delete ticket"))
			deleteTicket(example);
		else if(msg.equals("add flight"))
			addFlight(example);
		else if(msg.equals("delete flight"))
			deleteFlight(example);

		
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
	
	public static void book(Data data) throws ClassNotFoundException, SQLException {
		Connection con = Database.connectToDatabase();
		Database.book(data);
		con.close();
	}

	public static void deleteTicket(Data data) throws SQLException, ClassNotFoundException {
		Connection con = Database.connectToDatabase();
		Database.deleteTicket(data);
		con.close();
	}
	
	private static void addFlight(Data example) throws SQLException, ClassNotFoundException {
		Connection con = Database.connectToDatabase();
		Database.addFlight(example);
		con.close();
		
	}
	
	private static void deleteFlight(Data example) throws SQLException, ClassNotFoundException {
		Connection con = Database.connectToDatabase();
		Database.deleteFlight(example);
		con.close();
	}
}
