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

/*
 * In this project we are going to implement global exception handling using SpringAOP
 *    We are not supposed to handle exceptions in rest controller class
 *    So, we will use @RestControllerAdviser (class level) and @ExceptionHandling on method with exception class as parameter for this // CHECK CODE
 *    I also added a generic exception at the end
 *    
 *    We don't define or specify anything about this RestControllerAdviser in service or controller layer
 *    	In case of an exception dispatcher handler will automatically make use of RestControllerAdviser for exceptions
 *    
 *    I have defined ErrorDetails class to get detailed info on what went wrong and return this class JAva object and Spring will automatically 
 *    	convert it into JSON object
 */

@RestController
public class TouristController {
	
	@Autowired
	ITouristService touristService;
	

	@PostMapping("/register")
	public ResponseEntity<String>  saveTourist(@RequestBody Tourist tourist){
		
		return new ResponseEntity<String>(touristService.registerTourist(tourist), HttpStatus.CREATED);
		
	}
	

	@GetMapping("/getbyId/{id}")
	public ResponseEntity<Tourist> getTourist(@PathVariable Integer id) {

		Tourist tourist = touristService.touristById(id);
		return new ResponseEntity<Tourist>(tourist,HttpStatus.OK);

	}
	
	@GetMapping("/fetchAll")
	public ResponseEntity<List<Tourist>>  getAllTourist(){

		List<Tourist> listTourist = touristService.fetchTourists();
		return new ResponseEntity<List<Tourist>>(listTourist, HttpStatus.OK);


	}
	
	
	@PutMapping("/updateTourist")
	public ResponseEntity<String> updateTourist(@RequestBody Tourist tourist){

			String str = touristService.updateTourist(tourist);
			return new ResponseEntity<String>(str, HttpStatus.OK);

	}
	
	// For minimal information update we are going with patch mapping
	@PatchMapping("/updateTouristBudget/{id}/{budget}")
	public ResponseEntity<String> updateTouristBudget(@PathVariable("id") Integer id, @PathVariable("budget") Double budget){
		
			String str = touristService.updateTouristBudget(id, budget);
			return new ResponseEntity<String>(str, HttpStatus.OK);

	}
	
	@DeleteMapping("/deleteById/{id}")
	public ResponseEntity<String> deleteRecordById(@PathVariable Integer id){

			String str = touristService.deleteById(id);
			return new ResponseEntity<String>(str, HttpStatus.OK);

	}
}
