package com.restfulservices.springweb.rest_launcher3.exception;


public class TouristNotFoundException extends RuntimeException{
	
	public TouristNotFoundException(String comments) {
		super(comments);
	}
	
}
