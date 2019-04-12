package businessLogic;

public class Ticket {
	
	private int ticketNo = 1000;			//set to a random number. 
	private String userName;
	private String FlightID;
	
	
	public int getTicketNo() {
		return ticketNo++;
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
	public String getFlightID() {
		return FlightID;
	}
	public void setFlightID(String flightID) {
		FlightID = flightID;
	}
	
	
}
