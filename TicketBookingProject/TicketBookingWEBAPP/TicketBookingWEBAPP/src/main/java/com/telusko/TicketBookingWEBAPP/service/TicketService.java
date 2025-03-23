package com.telusko.TicketBookingWEBAPP.service;

/*
 * To invoke an other API we have two different methods
 * 	1) REST TEMPLATE
 *  2) WEB CLIENT (Need to add webflux dependency)
 */

// RestTemplate supports only synchronous communication

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.telusko.TicketBookingWEBAPP.model.Passenger;
import com.telusko.TicketBookingWEBAPP.model.Ticket;
@Service
public class TicketService implements ITicketService
{

	private String url="http://localhost:8485/TicketBookingAPI/api/book-ticket/get-ticketnumber";
	private String get_url="http://localhost:8485/TicketBookingAPI/api/book-ticket/get-ticket/{ticketNumber}";

	@Override
	public Integer registerPassenger(Passenger passenger)
	{
		//RestTemplate and WebClient
//		RestTemplate restTemplate = new RestTemplate();
		//For post request we use .postForEntity method,Passenger is the body of the request, Integer.class is the type of response we are expecting
//		ResponseEntity<Integer> response = restTemplate.postForEntity(url, passenger, Integer.class);
//		Integer ticketNumber = response.getBody();
		WebClient webClient = WebClient.create(); // Create an object of webclient
		Integer ticketNumber=webClient.post()
		.uri(url)
		.bodyValue(passenger)
		.retrieve()
		.bodyToMono(Integer.class)
		.block(); // For synchronous communication and for asynchronous communication we use subscribe 
		return ticketNumber;
	}

	@Override
	public Ticket getFullTicket(Integer ticketNumber)
	{
//		RestTemplate restTemplate = new RestTemplate();
		//For post request we use .getForEntity method and the path parameter will be added at the end
//		ResponseEntity<Ticket> response = restTemplate.getForEntity(get_url, Ticket.class, ticketNumber);
//		Ticket ticket=response.getBody();
		//Integer ticketNumber = response.getBody();
		WebClient webClient = WebClient.create();
		Ticket ticket = webClient.get()
		.uri(get_url, ticketNumber) // we are passing path parameter here
		.retrieve()
		.bodyToMono(Ticket.class)
		.block();
		return ticket;
	}

}
