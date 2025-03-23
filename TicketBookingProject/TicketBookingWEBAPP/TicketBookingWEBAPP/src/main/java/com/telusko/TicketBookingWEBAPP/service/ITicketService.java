package com.telusko.TicketBookingWEBAPP.service;

import com.telusko.TicketBookingWEBAPP.model.Passenger;
import com.telusko.TicketBookingWEBAPP.model.Ticket;

public interface ITicketService 
{
	public Integer registerPassenger(Passenger passenger);
	public Ticket getFullTicket(Integer ticketNumber);
}
