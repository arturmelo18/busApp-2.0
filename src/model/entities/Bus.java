package model.entities;

public class Bus {

	private String exitLocation;
	private String destination;
	private Double ticketPrice;

	private String[] seats = new String[50];

	public Bus(String exitLocation, String destination, Double ticketPrice) {
		this.exitLocation = exitLocation;
		this.destination = destination;
		this.ticketPrice = ticketPrice;
	}

	public String getExitLocation() {
		return exitLocation;
	}

	public void setExitLocation(String exitLocation) {
		this.exitLocation = exitLocation;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public Double getTicketPrice() {
		return ticketPrice;
	}

	public void setTicketPrice(Double ticketPrice) {
		this.ticketPrice = ticketPrice;
	}

	public String[] getSeats() {
		return seats;
	}

	public String toString() {
		return "Exit location: " + exitLocation + ". Destination:" + destination;
	}
}
