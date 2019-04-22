package userInterface;

import java.math.BigDecimal;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import java.util.ResourceBundle;

import businessLogic.Flight;
import businessLogic.Ticket;
import data.Data;
import data.HandleExceptions;
import database.Database;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class MainPageController implements Initializable {
	
	@FXML
	private SplitPane MainPage;
	@FXML
	private AnchorPane UserPage;
	@FXML
	private AnchorPane AdminPage;
	@FXML
	private TableView<Flight> FlightTable;
	@FXML
	private TableColumn<Flight, Integer> col_FlightID;
	@FXML
	private TableColumn<Flight, String> col_depCity;
	@FXML
	private TableColumn<Flight, String> col_arrCity;
	@FXML
	private TableColumn<Flight, String> col_flightTime;
	@FXML
	private TableColumn<Flight, String> col_flightDate;
	@FXML
	private TableColumn<Flight, Integer> col_price;
	@FXML
	private TableColumn<Flight, Integer> col_seats;
	@FXML
	private DatePicker datePicker;
	@FXML
	private ChoiceBox<String> from;
	@FXML
	private ChoiceBox<String> To;
	@FXML
	private TableView<Ticket> ticketsBookedTable;
	
	@FXML
    private TableColumn<Ticket, Integer> col_TickteNum;

    @FXML
    private TableColumn<Ticket, Integer> col_flightId;

    @FXML
    private TableColumn<Ticket, String> col_userName;
	@FXML
	private Label booked;
	@FXML
	private Label allFlightsLabel;
	@FXML
	private Button searchButton;
	@FXML
	private ChoiceBox<String> departingCities;
	@FXML
	private Label adminTools;
	@FXML
	private TextField flight_Id;
	@FXML
	private TextField price;
	@FXML
	private DatePicker datePickerAdmin;
	@FXML
	private ChoiceBox<String> arrivalCities;
	@FXML
	private ChoiceBox<String> departingTime;
	@FXML
	private TextField seats;
	@FXML
	private Button addButtonAdm;
	@FXML
	private Button editButtonAdm;
	@FXML
	private Button delButtonAdm;
	@FXML
	private ImageView picture;
	@FXML
    private Button bookButton;
    @FXML
    private Button refreshButton;
    @FXML
    private Button logoutButton;
    @FXML
    private Button deleteButton;
    
    
    private static String usern;
	
	
	ObservableList<Flight> data = FXCollections.observableArrayList();
	ObservableList<Ticket> tickets = FXCollections.observableArrayList();
	ObservableList<String> cities = FXCollections.observableArrayList("ATL", "LA", "TX","NYC","NO", "DC");
	ObservableList<String> time = FXCollections.observableArrayList("05:00","07:00","09:00", "10:00", "11:00", "13:45","15:00","18:00");

    
    @FXML
    void bookedClicked(MouseEvent event) throws Exception {
    	
    	//this gets an instance of the object flight from table, then I can cast it to data and have it go through all the logic/error catching.
    	Flight flight = FlightTable.getSelectionModel().getSelectedItem();
    	
    	//if the flight is full we can check before checking the database. 
    	if(flight.getSeats() == 0)
    		Alerts.alert1("Flight is full");
    		
    	else {
    	
    	
    	//random number for the ticket number , and get the flight id from the table
    	Random r = new Random();
    	Ticket t = new Ticket(r.nextInt(9999-1000) + 1000, flight.getFlightID(),usern);
    	Data d = new Data();
    	d.setTicket(t);
    	HandleExceptions.checkExceptions(d, "booking");
    	
    	}
    	
    	refresh();
    }
    
    //update so that this isn't a button and is only a method so that the refresh can be called after any button press.
    @FXML
    void logOutClicked(MouseEvent event) {
    	MainPage.getScene().getWindow().hide();
    }

    @FXML
    void searchClicked(MouseEvent event) {
    	//actually shouldn't need to do this, I should be able to search the onbservable list for the 
    	data.clear();
    	try {
		updateFlightTable("select * from flight where startCity = "+ "'" + from.getValue() + "'" + " and endCity = "+ "'"
				+ To.getValue() + "'" + " and flightDate = " + "'" + datePicker.getValue().toString() + "'");
    	}
    	catch(Exception ex) {
    		FlightTable.setItems(data);
    	}
		
    }
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		//this is the drop down menues
		arrivalCities.setItems(cities);
		arrivalCities.getSelectionModel().select(0);
		departingCities.setItems(cities);
		departingCities.getSelectionModel().select(5);
		from.setItems(cities);
		from.getSelectionModel().select(0);
		To.setItems(cities);
		To.getSelectionModel().select(5);
		departingTime.setItems(time);
		departingTime.getSelectionModel().select(0);
		
		//this populates the tables at the opening of the mainPage
	
		updateFlightTable("select * from flight");
		updateTicketTable("select ticket_no, flightid, username from flight_ticket where userName = ?");
		
		if(!usern.equalsIgnoreCase("admin")) {
			AdminPage.setVisible(false);;
			
		}
	}
	//select userName from flight_ticket, user where flight_ticket.ssn = user.ssn; this will return a username
	
	public void updateFlightTable(String msg) {
		
		try {
			col_FlightID.setCellValueFactory(new PropertyValueFactory<>("flightID"));
			col_depCity.setCellValueFactory(new PropertyValueFactory<>("startCity"));
			col_arrCity.setCellValueFactory(new PropertyValueFactory<>("endCity"));
			col_flightTime.setCellValueFactory(new PropertyValueFactory<>("flightTime"));
			col_price.setCellValueFactory(new PropertyValueFactory<>("price"));
			col_seats.setCellValueFactory(new PropertyValueFactory<>("seats"));
			col_flightDate.setCellValueFactory(new PropertyValueFactory<>("flightDate"));
			
			Connection con = Database.connectToDatabase();
			ResultSet rs = con.createStatement().executeQuery(msg);
			
			while(rs.next()) {
				data.add(new Flight(rs.getInt("flightid"), rs.getString("startCity"), rs.getString("endCity"), rs.getString("flightTime"), 
						rs.getInt("price"), rs.getString("flightDate"), rs.getInt("seats")));
			}
			FlightTable.setItems(data);
		
			//set ticket table
			con.close();
		
		} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
	
	}
	
	public void updateTicketTable(String msg) {
		//select userName from flight_ticket, user where flight_ticket.ssn = user.ssn; this will return a username
		try {
			col_TickteNum.setCellValueFactory(new PropertyValueFactory<>("ticketNo"));
			col_flightId.setCellValueFactory(new PropertyValueFactory<>("FlightID"));
			col_userName.setCellValueFactory(new PropertyValueFactory<>("userName"));
			
			
			Connection con = Database.connectToDatabase();	
			PreparedStatement s = con.prepareStatement(msg);
			s.setString(1, usern);
			ResultSet rs = s.executeQuery();
			
			while(rs.next()) {
				tickets.add(new Ticket(rs.getInt("ticket_no"), rs.getInt("flightid"), rs.getString("username")));
			}
			ticketsBookedTable.setItems(tickets);
		
			//set ticket table
			con.close();
		
		} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
	
	}
	
	   @FXML
	    void adminAdd(MouseEvent event) {
		   
		   Flight flight = new Flight();
		   flight.setStartCity(departingCities.getValue());
		   flight.setEndCity(arrivalCities.getValue());
		   flight.setFlightDate(datePickerAdmin.getValue().toString());
		   flight.setFlightID(Integer.parseInt(flight_Id.getText()));
		   flight.setFlightTime(departingTime.getValue());
		   flight.setPrice(Integer.parseInt(price.getText()));
		   flight.setSeats(Integer.parseInt(seats.getText()));
		   Data d = new Data();
		   d.setFlight(flight);
		   try {
			HandleExceptions.checkExceptions(d, "add flight");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   refresh();
	    }

	    @FXML
	    void adminDelete(MouseEvent event) {
	    	
	    	Flight flight = FlightTable.getSelectionModel().getSelectedItem();
	    	Data d = new Data();
	    	d.setFlight(flight);
	    	try {
				HandleExceptions.checkExceptions(d, "delete flight");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	
	    	refresh();
	    }

	    @FXML
	    void adminEdit(MouseEvent event) throws Exception {
	    	Flight flight = new Flight();
	    	flight.setFlightID(FlightTable.getSelectionModel().getSelectedItem().getFlightID());
	    	flight.setSeats(Integer.parseInt(seats.getText()));
	    	flight.setPrice(Integer.parseInt(price.getText()));
	    	Data d = new Data();
	    	d.setFlight(flight);
	    	
	    	HandleExceptions.checkExceptions(d, "edit");
	    	refresh();
	    }

	    @FXML
	    void deleteClicked(MouseEvent event) throws Exception {
	    	
	    	Ticket ticket = ticketsBookedTable.getSelectionModel().getSelectedItem();
	    	Data d = new Data();
	    	d.setTicket(ticket);
	    	HandleExceptions.checkExceptions(d, "delete ticket");
	    	
	    	refresh();
	    }
	    
	    @FXML
	    void refreshClicked(MouseEvent event) {
	    	refresh();
	    }

		public static void setUserName(String string) {
			usern = string;
		}
		
		public void refresh() {
	    	data.clear();
	    	tickets.clear();
	    	updateFlightTable("select * from flight");
	    	updateTicketTable("select ticket_no, flightid, username from flight_ticket where userName = ?");
		}
}



