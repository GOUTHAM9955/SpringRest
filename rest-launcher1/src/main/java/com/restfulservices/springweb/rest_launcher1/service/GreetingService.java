package com.restfulservices.springweb.rest_launcher1.service;

import java.time.LocalTime;

import org.springframework.stereotype.Service;

@Service
public class GreetingService implements IGreetingService {
	

	@Override
	public String generatWishes(String name) {
		
		LocalTime time  = LocalTime.now();
		int hour = time.getHour();
		
		if(hour<12) {
			return "Good Morning: " + name;
		}
		
		else if(hour<15) {
			return "Good Afternoon: " + name;
		}
		
		if(hour<18) {
			return "Good Evening: " + name;
		}
		
		else {
			return "Good Night: " + name;
		}
		
	}

}
