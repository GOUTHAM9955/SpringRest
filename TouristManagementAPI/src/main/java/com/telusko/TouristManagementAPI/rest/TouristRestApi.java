package com.telusko.TouristManagementAPI.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.telusko.TouristManagementAPI.exception.TouristNotFoundException;
import com.telusko.TouristManagementAPI.model.Tourist;
import com.telusko.TouristManagementAPI.service.ITouristService;

@RestController
//@Scope("request")
@Scope("session")
public class TouristRestApi 
{
	@Autowired
	private ITouristService service;
	
	public TouristRestApi()
	{
		System.out.println("TouristRestApi Bean created");
	}
	
	@PostMapping("/regTourist")
	public ResponseEntity<String> registerTourist(@RequestBody Tourist tourist)
	{
		String response= service.registerTourist(tourist);
		return new ResponseEntity<String>(response, HttpStatus.CREATED);	
	}
	
	@GetMapping("/getTourist/{id}")
	public ResponseEntity<?> getTourist(@PathVariable("id") Integer id)
	{
		try
		{
			Tourist tourist = service.fetchTouristById(id);
			return new ResponseEntity<Tourist>(tourist, HttpStatus.OK);
		}
		catch(TouristNotFoundException e)
		{
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/getalltourist")
	public ResponseEntity<?> getAllTourist()
	{
		try
		{
			List<Tourist> tourists= service.fetchAllTouristInfo();
			return new ResponseEntity<List>(tourists, HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<String>("Some problem in fetch", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@PutMapping("/updatetourist")
	public ResponseEntity<String> updateTheTourist(@RequestBody Tourist tourist)
	{
		try
		{
			String status=service.updateTheTouristInfo(tourist);
			return new ResponseEntity<String>(status, HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@PatchMapping("/updatetouristbudget/{id}/{budget}")
	public ResponseEntity<String> updateTheTourist(@PathVariable("id")Integer id, 
			@PathVariable("budget") Double budget)
	{
		try
		{
			String status=service.updateTheTouristBudget(id, budget);
			return new ResponseEntity<String>(status, HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	@DeleteMapping("/deletetourist/{id}")
	public ResponseEntity<String> deleteTheTourist(@PathVariable("id")Integer id)
	{
		try
		{
			String status=service.deleteTouristInfoById(id);
			return new ResponseEntity<String>(status, HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

}
