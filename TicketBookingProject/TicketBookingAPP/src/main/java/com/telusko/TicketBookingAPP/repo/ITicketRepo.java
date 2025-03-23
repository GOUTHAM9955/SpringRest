package com.telusko.TicketBookingAPP.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.telusko.TicketBookingAPP.model.Passenger;
@Repository
public interface ITicketRepo extends JpaRepository<Passenger,Integer>
{

}
