package com.telusko.TicketBookingAPP.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.telusko.TicketBookingAPP.model.Passenger;
import com.telusko.TicketBookingAPP.model.Ticket;
import com.telusko.TicketBookingAPP.service.ITicketService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("api/book-ticket")
@Tag(name="TicketBookingAPI", description="There are 2 apis one will accept Passenger info and generfate ticket number a nd other will generate full Ticket info based on ticket number")
public class TicketController 
{
	@Autowired
	private ITicketService service;
	
	@PostMapping("/get-ticketnumber")
	@Operation(summary="POST Operation", description="This API will accept Passenger info and Generate Ticket number")
	public ResponseEntity<Integer> registerPassenger(@RequestBody Passenger passenger)
	{
		Passenger pass = service.registerPassenger(passenger);
		Integer ticketNumber=pass.getPid();
		return new ResponseEntity<Integer>(ticketNumber, HttpStatus.CREATED);
	}
	
	@GetMapping("/get-ticket/{ticketNumber}")
	@Operation(summary="GET Operation", description="This API will accept Ticket Number and Generate FULL Ticket")
	public ResponseEntity<Ticket> getTicket(@PathVariable("ticketNumber")Integer ticketNumber)
	{
		Passenger passenger = service.fetchPassengerInfo(ticketNumber);
		Ticket ticket=new Ticket();
		ticket.setTicketNumber(passenger.getPid());
		ticket.setName(passenger.getName());
		ticket.setDeparture(passenger.getDeparture());
		ticket.setArrival(passenger.getArrival());
		ticket.setDateOfJourney(passenger.getDateOfJourney());
		ticket.setStatus("confirmed");
		ticket.setTicketPrice(555.5);
		return new ResponseEntity<Ticket>(ticket, HttpStatus.OK);
	}

}
