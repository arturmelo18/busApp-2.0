package model.services;

import model.entities.Bus;

public class BusPaymentUSA implements BusPayment {

	public static Double TAX = 0.5;

	@Override
	public double priceTicketBus(Bus bus) {
		return bus.getTicketPrice() * TAX;
	}
}
