package businessLogic;

import java.math.BigDecimal;

public class Flight {

	private int flightID;
	private String startCity;
	private String endCity;
	private String flightTime;
	private int price;
	private String flightDate;
	private int seats;
	
	public Flight() {
		
	}
	
	public Flight(int flightID, String startCity, String endCity, String flightTime, int price,
			String flightDate, int seats) {
		super();
		this.flightID = flightID;
		this.startCity = startCity;
		this.endCity = endCity;
		this.flightTime = flightTime;
		this.price = price;
		this.flightDate = flightDate;
		this.seats = seats;
	}
	
	public String getFlightDate() {
		return flightDate;
	}
	public void setFlightDate(String flightDate) {
		this.flightDate = flightDate;
	}
	public int getSeats() {
		return seats;
	}
	public void setSeats(int seats) {
		this.seats = seats;
	}
	public String getStartCity() {
		return startCity;
	}
	public void setStartCity(String startCity) {
		this.startCity = startCity;
	}
	public String getEndCity() {
		return endCity;
	}
	public void setEndCity(String endCity) {
		this.endCity = endCity;
	}
	public String getFlightTime() {
		return flightTime;
	}
	public void setFlightTime(String flightTime) {
		this.flightTime = flightTime;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getFlightID() {
		return flightID;
	}
	public void setFlightID(int flightID) {
		this.flightID = flightID;
	}

}
