package com.restfulservices.springweb.rest_launcher3.advise;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.restfulservices.springweb.rest_launcher3.exception.TouristNotFoundException;

@RestControllerAdvice
public class TouristControllerAdvice {
	
	@ExceptionHandler(TouristNotFoundException.class)
	public ResponseEntity<ErrorDetails> hadleTouristExceptions(TouristNotFoundException exc){
		ErrorDetails err = new ErrorDetails("404 not found", exc.getMessage(), LocalDateTime.now());
		return new ResponseEntity<ErrorDetails>(err, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> hadleGeneralTouristExceptions(Exception exc){
		ErrorDetails err = new ErrorDetails("Internal Server Error", exc.getMessage(), LocalDateTime.now());
		return new ResponseEntity<ErrorDetails>(err, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
