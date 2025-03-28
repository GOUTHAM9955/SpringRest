package com.telusko.RestApiApp1.service;

import java.time.LocalTime;

import org.springframework.stereotype.Service;

@Service
public class GreetingsService implements IGreetings
{
	
	@Override
	public String generateWish(String name)
	{
		LocalTime time=LocalTime.now();
		int hour=time.getHour();
		if(hour<12)
			return "Good Morning "+name;
		else if(hour<16)
			return "Good Aftrenoon "+name;
		else if(hour<20)
			return "Good Evening "+name;
		else
			return "Good Night"+name;
	}

}
