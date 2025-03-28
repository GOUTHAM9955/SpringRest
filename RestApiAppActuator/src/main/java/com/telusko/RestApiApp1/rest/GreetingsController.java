package com.telusko.RestApiApp1.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.telusko.RestApiApp1.service.IGreetings;

//@Controller + @ResponseBody ===> @RestController
@RestController
@RequestMapping("api1")
public class GreetingsController 
{
	@Autowired
	private IGreetings greeting;
	
	@GetMapping("/greet")
	public ResponseEntity<String> getWishes()
	{
		String res=greeting.generateWish("Vishal");
		return new ResponseEntity<String>(res, HttpStatus.OK);
	}
	
	@GetMapping("/greet2")
	public String getWishes2()
	{
		String res=greeting.generateWish("Vishal");
		return res;
	}
	

}
