package com.gainsight.mvc.entity;

public class Bookings {
     
	
	private String bookingId;
	private String flightId;
	private String passengerId;
	private String travelDate;
	public Bookings() {}
	public Bookings(String bookingId, String flightId, String passengerId, String travelDate) {
		super();
		this.bookingId = bookingId;
		this.flightId = flightId;
		this.passengerId = passengerId;
		this.travelDate = travelDate;
	}
	public String getBookingId() {
		return bookingId;
	}
	public void setBookingId(String bookingId) {
		this.bookingId = bookingId;
	}
	public String getFlightId() {
		return flightId;
	}
	public void setFlightId(String flightId) {
		this.flightId = flightId;
	}
	public String getPassengerId() {
		return passengerId;
	}
	public void setPassengerId(String passengerId) {
		this.passengerId = passengerId;
	}
	public String getTravelDate() {
		return travelDate;
	}
	public void setTravelDate(String travelDate) {
		this.travelDate = travelDate;
	}
	
}
