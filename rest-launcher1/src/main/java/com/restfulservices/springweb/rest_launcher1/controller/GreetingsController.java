package com.restfulservices.springweb.rest_launcher1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.restfulservices.springweb.rest_launcher1.service.IGreetingService;

@Controller
public class GreetingsController {
	
	@Autowired
	private IGreetingService greetingService;
	
	// It is not mandatory to have return type as ResponseEntity but it is recommended of which which we I mentioned upcoming projects 
	@GetMapping("/greet")
	@ResponseBody // This ResponseBody annotation indicates that it is a RESTAPI 
	public ResponseEntity<String> getWishes(){
		String[] str = new String[6];
		String response = greetingService.generatWishes("Goutham");
		//System.out.println("I am here");
		return new ResponseEntity<String>(response, HttpStatus.OK);
		
	}
	
	// Sample example to get data from client
	// @RequestBody Annotation is must to convert JASON body to java object 
	@PostMapping("/name")
	public ResponseEntity<String> getName(@RequestBody String name){
	System.out.println(name);
	return new ResponseEntity<String>(greetingService.generatWishes(name), HttpStatus.OK);
	}

}
