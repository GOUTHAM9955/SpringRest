package com.telusko.RestApiApp1.service;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Primary
@Profile("devops")
public class DevOps implements ICourse {
	
	public DevOps()
	{
		System.out.println("DevOps bean created");
	}

	@Override
	public Boolean getTheCourse(Double amount) {
		System.out.println("DevOps course purchased and amount paid is "+ amount);
		return true;
	}

}
