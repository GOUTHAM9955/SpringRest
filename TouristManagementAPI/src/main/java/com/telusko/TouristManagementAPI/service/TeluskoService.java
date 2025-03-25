package com.telusko.TouristManagementAPI.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeluskoService 
{
	@Autowired
	private ITouristService service;
	
	public TeluskoService()
	{
		System.out.println("TeluskoService Bean created");
	}
	

}
