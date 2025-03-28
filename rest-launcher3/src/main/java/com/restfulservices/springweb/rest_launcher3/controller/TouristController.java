package com.restfulservices.springweb.rest_launcher3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.restfulservices.springweb.rest_launcher3.exception.TouristNotFoundException;
import com.restfulservices.springweb.rest_launcher3.model.Tourist;
import com.restfulservices.springweb.rest_launcher3.service.ITouristService;



@RestController
public class TouristController {
	
	@Autowired
	ITouristService touristService;
	
	
	// SINCE WE ARE CREATING A RECORD WE RESPONSED BACK WITH HttpStatus.CREATED RESPONSE 
	@PostMapping("/register")
	public ResponseEntity<String>  saveTourist(@RequestBody Tourist tourist){
		
		return new ResponseEntity<String>(touristService.registerTourist(tourist), HttpStatus.CREATED);
		
	}
	
	//CHECK HOW WE ARE DIFINING THE PATH PARAMETER IN REQUEST MAPPING
	//IN CATCH BLOCK WE DEFINED http BAD REQUEST IN RESPONSE ENTITY
	
	// In spring boot application we globally handle the exceptions and won't write try and catch blocks. We wills e it later how to handle those
	// The custom exception handling extends RuntimeException to make it as uncheck exception
	@GetMapping("/getbyId/{id}")
	public ResponseEntity<?> getTourist(@PathVariable Integer id) {
		try {
		Tourist tourist = touristService.touristById(id);
		return new ResponseEntity<Tourist>(tourist,HttpStatus.OK);
		}
		catch(TouristNotFoundException e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/fetchAll")
	public ResponseEntity<?>  getAllTourist(){
		try {
		List<Tourist> listTourist = touristService.fetchTourists();
		return new ResponseEntity<List<Tourist>>(listTourist, HttpStatus.OK);
		}
		catch (Exception e) {
			
			return new ResponseEntity<String>("InternalServer_Error", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@PutMapping("/updateTourist")
	public ResponseEntity<String> updateTourist(@RequestBody Tourist tourist){
		try {
			String str = touristService.updateTourist(tourist);
			return new ResponseEntity<String>(str, HttpStatus.OK);
		}
		
		catch(TouristNotFoundException e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
	}
	
	// For minimal information update we are going with patch mapping
	@PatchMapping("/updateTouristBudget/{id}/{budget}")
	public ResponseEntity<String> updateTouristBudget(@PathVariable("id") Integer id, @PathVariable("budget") Double budget){
		try {
			String str = touristService.updateTouristBudget(id, budget);
			return new ResponseEntity<String>(str, HttpStatus.OK);
		}
		
		catch(TouristNotFoundException e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/deleteById/{id}")
	public ResponseEntity<String> deleteRecordById(@PathVariable Integer id){
		try {
			String str = touristService.deleteById(id);
			return new ResponseEntity<String>(str, HttpStatus.OK);
		}
		catch(TouristNotFoundException e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
	}
}
