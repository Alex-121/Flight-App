package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import businessLogic.Flight;
import businessLogic.Ticket;
import data.Data;
import data.customException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;
import userInterface.MainPageController;

public class Database {
	
	private static Connection con;
	private static final String USERNAME = "root";
	private static final String PASSWORD = "12345678";
	private static final String CONN_STRING = "jdbc:mysql://127.0.0.1:3306/project?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
			
	
	public Database() throws ClassNotFoundException, SQLException {
		
		Database.connectToDatabase();
	}
	
	
	public static Connection connectToDatabase() throws ClassNotFoundException, SQLException {
		con = DriverManager.getConnection(CONN_STRING,USERNAME,PASSWORD);
		System.out.println("Connected");
		return con;
	
	}
	
	
	
	public static void addUser(Data data) throws SQLException {
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
	
	public static void addFlight(Data a) throws SQLException {
		
		String query = "insert into flight (flightid,startcity,endcity,flighttime,flightdate,price,seats) "
				+ "values (?,?,?,?,?,?,?)";
		PreparedStatement smt = con.prepareStatement(query);
		smt.setInt(1, a.getFlight().getFlightID());
		smt.setString(2,a.getFlight().getStartCity());
		smt.setString(3, a.getFlight().getEndCity());
		smt.setString(4, a.getFlight().getFlightTime());
		smt.setString(5, a.getFlight().getFlightDate());
		smt.setInt(6, a.getFlight().getPrice());
		smt.setInt(7, a.getFlight().getSeats());
		
		smt.execute();
	}
	
	public static void login(Data example) throws SQLException, customException {
		
		ResultSet rs;
		String query = " select pass from user where userName = ?";
		PreparedStatement smt = con.prepareStatement(query);
		smt.setString(1, example.getPerson().getUserName());
		rs =smt.executeQuery();
		if(rs.next()) {					//this means the userName was found
			if(rs.getString("pass").equalsIgnoreCase(example.getPerson().getPass())) 
				throw new customException("passwords match");
				//System.out.println("passwords match");
				
				else					//passwords don't match
					throw new SQLException("Password doesn't match.");
			
			
		}
		else
			throw new customException("User name not found. Please sign up");
	}
	

	public static void book(Data data) throws SQLException {
		
		
		ResultSet rs;
		int test = 0;
		String query ="select ssn from project.user where username = ?";
		PreparedStatement smt = con.prepareStatement(query);
		smt.setString(1, data.getTicket().getUserName());
		rs = smt.executeQuery();
		while(rs.next()) {
			test = Integer.parseInt(rs.getString("ssn"));
		}
		
		query = "insert into flight_ticket (ticket_No, ssn, flightid, username) values(?,?,?,?)";
		smt = con.prepareStatement(query);
		smt.setInt(1, data.getTicket().getTicketNo());
		smt.setInt(2, test);
		smt.setInt(3, data.getTicket().getFlightID());
		smt.setString(4, data.getTicket().getUserName());
		
		try {
			smt.execute();
		} catch (SQLException e) {
			throw new SQLException("Flight already booked");
		}
		
		query = "UPDATE project.flight SET seats = seats - 1 WHERE (flightid = ?)";
		smt = con.prepareStatement(query);
		smt.setInt(1, data.getTicket().getFlightID());
		
		smt.execute();
	}
	

	public static void closeConnection() throws SQLException {
		
		con.close();
		System.out.println("connection closed");
	}



	public static void deleteTicket(Data data) throws SQLException {
		String query = "delete from flight_ticket where flightid = ?";
		PreparedStatement smt = con.prepareStatement(query);
		smt.setInt(1, data.getTicket().getFlightID());
		smt.executeUpdate();
		
		query = "UPDATE project.flight SET seats = seats + 1 WHERE (flightid = ?)";
		smt = con.prepareStatement(query);
		smt.setInt(1, data.getTicket().getFlightID());
		
		smt.execute();
			
	}


	public static void deleteFlight(Data example) throws SQLException {
		String query = "delete from flight where flightid = ?";
		PreparedStatement smt = con.prepareStatement(query);
		smt.setInt(1, example.getFlight().getFlightID());
		smt.executeUpdate();
	}


	public static void checkQuestion(Data example) throws SQLException {
		String query = "select answer from project.user where seqQuestion = ? and email = ?";
		PreparedStatement smt = con.prepareStatement(query);
		smt.setString(1, example.getPerson().getQuestion());
		smt.setString(2, example.getPerson().getEmail());
		ResultSet rs;
		
		rs =smt.executeQuery();
		
		while(rs.next()) {
			if(!rs.getString("answer").equals(example.getPerson().getAnswer()))
				throw new SQLException("Check answer.");		
		}
		//if above is true, it shouldn't get to this line
		
		query = "select pass from project.user where seqQuestion = ? and email = ?";
		smt = con.prepareStatement(query);
		smt.setString(1, example.getPerson().getQuestion());
		smt.setString(2, example.getPerson().getEmail());
		
		
		rs =smt.executeQuery();
		while(rs.next()) {
			throw new SQLException("Your password is " + rs.getString("pass"));
		}
		
	}


	public static void editFlight(Data example) throws SQLException {
		String query = "UPDATE project.flight SET price = ?, seats = ? WHERE (flightid = ?)";
		PreparedStatement smt = con.prepareStatement(query);
		smt.setInt(1, example.getFlight().getPrice());
		smt.setInt(2, example.getFlight().getSeats());
		smt.setInt(3, example.getFlight().getFlightID());
		
		smt.executeUpdate();
	}

	



	
}