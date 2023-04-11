package model.services;

import model.entities.Bus;

public class BusPaymentBrazil implements BusPayment {

	public static Double TAX = 1.25;

	@Override
	public double priceTicketBus(Bus bus) {
		return bus.getTicketPrice() * TAX;
	}
}
