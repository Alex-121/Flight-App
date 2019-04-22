package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import data.Data;

public class Database {
	
	private Connection con;
	private static final String USERNAME = "root";
	private static final String PASSWORD = "1234";
	private static final String CONN_STRING = "jdbc:mysql://127.0.0.1:3306/project";
	
	
	public Database() throws ClassNotFoundException, SQLException {
		
		this.connectToDatabase();
	}
	
	
	public void connectToDatabase() throws ClassNotFoundException, SQLException {
		con = DriverManager.getConnection(CONN_STRING,USERNAME,PASSWORD);
		System.out.println("Connected");
	}
	
	
	
	public void addUser(Data data) throws SQLException {
		String query = " insert into user (fName, lName, address, zip, state, userName, pass, email, seqQuestion, answer, ssn)"
		        + " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		PreparedStatement smt = con.prepareStatement(query);
		smt.setString(1, data.getPerson().getFirstName());
		smt.setString(2, data.getPerson().getLastName());
		smt.setString(3, data.getPerson().getAddress());
		smt.setInt(4, data.getPerson().getZip());
		smt.setString(5, data.getPerson().getState());
		smt.setString(6, data.getPerson().getUserName());
		smt.setString(7, data.getPerson().getPass());
		smt.setString(8, data.getPerson().getEmail());
		smt.setString(9, data.getPerson().getQuestion());
		smt.setString(10, data.getPerson().getAnswer());
		smt.setInt(11, data.getPerson().getSsn());;
		
		smt.execute();
	}
	
	public void addFlight(Data a) {
		
	}
	
	public void closeConnection() throws SQLException {
		
		con.close();
	}


	
}