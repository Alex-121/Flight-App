package businessLogic;

public class Ticket {
	
	private int ticketNo;			
	private String userName;
	private int FlightID;
	
	public Ticket(int ticketNo, int flightID, String userName) {
		
		this.ticketNo = ticketNo;
		this.userName = userName;
		FlightID = flightID;
	}
	public int getTicketNo() {
		return ticketNo;
	}
	public void setTicketNo(int ticketNo) {
		this.ticketNo = ticketNo;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getFlightID() {
		return FlightID;
	}
	public void setFlightID(int flightID) {
		FlightID = flightID;
	}
	

}
