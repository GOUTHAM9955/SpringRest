package com.telusko.TicketBookingAPP.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telusko.TicketBookingAPP.model.Passenger;
import com.telusko.TicketBookingAPP.repo.ITicketRepo;
@Service
public class TicketService implements ITicketService
{

	@Autowired
	private ITicketRepo repo;
	@Override
	public Passenger registerPassenger(Passenger passenger) {
	
		return repo.save(passenger);
	}

	@Override
	public Passenger fetchPassengerInfo(Integer id)
	{
		Optional<Passenger> optional = repo.findById(id);
		
		return optional.get();
	}

}
