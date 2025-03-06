package com.launch.jacksonapi;

import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/*
 * In this class we are trying to convert Java object to JSON format using Jackson API
 * 
 * For that we created a simple maven project and added Jackson dependency 
 *   >> Don't forget to change  JDK vesion
 *   
 *  Inside Jackson Api we have ObjectMapper class which we use for conversion 
 * 
 */

public class LaunchApp {
	
	
	public static void main(String[] args) throws JsonProcessingException {
		
		StudentModel student = new StudentModel(1, "GK", "gk1@gmail.com");
		
		ObjectMapper mapper = new ObjectMapper();
		
		//String json = mapper.writeValueAsString(student);
		
		// If we have multiple obejcts in a collection
		
		StudentModel student1 = new StudentModel(1, "GK1", "gk1@gmail.com");
		StudentModel student2 = new StudentModel(12, "GK2", "gk2@gmail.com");
		StudentModel student3 = new StudentModel(13, "GK3", "gk3@gmail.com");
		
		List<StudentModel> slist = Arrays.asList(student1, student2, student3);
		String json= mapper.writerWithDefaultPrettyPrinter().writeValueAsString(slist);
		
		System.out.println(json);
		
		
		
		
	}

}
