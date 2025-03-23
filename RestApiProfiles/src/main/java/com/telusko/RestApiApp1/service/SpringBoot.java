package com.telusko.RestApiApp1.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile({"sb","boot"})
public class SpringBoot implements ICourse {
	
	public SpringBoot()
	{
		System.out.println("SpringBoot bean created");
	}

	@Override
	public Boolean getTheCourse(Double amount) {
		System.out.println("Spring boot course purchased and amount paid is "+ amount);
		return true;
	}

}
