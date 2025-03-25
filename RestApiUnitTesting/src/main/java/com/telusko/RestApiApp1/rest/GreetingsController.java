package com.telusko.RestApiApp1.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.telusko.RestApiApp1.model.Student;
import com.telusko.RestApiApp1.service.IGreetings;

@RestController
public class GreetingsController 
{
	@Autowired
	private IGreetings service;
	
	@GetMapping("/greet")
	public ResponseEntity<String> getWishes()
	{
		String res=service.generateWish("Vishal");
		return new ResponseEntity<String>(res, HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<String> addStudent(@RequestBody Student data)
	{
		  System.out.println(data);
		 Boolean status= service.addStudent(data);
		 if(status)
		 {
			 String msg="Student Data added";
			 return new ResponseEntity<String>(msg, HttpStatus.OK);
		 }
		 else
		 {
			 String msg="Student data couldn't be added";
			 return new ResponseEntity<String>(msg, HttpStatus.INTERNAL_SERVER_ERROR);

		 }
	}

}
