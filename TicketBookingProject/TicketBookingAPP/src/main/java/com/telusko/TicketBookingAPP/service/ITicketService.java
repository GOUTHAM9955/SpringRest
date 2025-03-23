package com.telusko.TicketBookingAPP.service;

import com.telusko.TicketBookingAPP.model.Passenger;

public interface ITicketService
{
	Passenger registerPassenger(Passenger passenger);
	Passenger fetchPassengerInfo(Integer id);
}
