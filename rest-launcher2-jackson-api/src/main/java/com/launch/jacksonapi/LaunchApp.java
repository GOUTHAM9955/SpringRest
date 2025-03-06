package com.launch.jacksonapi;

import java.util.Arrays;
import java.util.List;
import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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

/*
 * Spring will internally implement this jackson API and it will use @JsonIgnoreProperties annotations too when we apply @RequestBody to the mapping method
 */

// If the JSON file has any unknown fields that doesn't match with the model class adding this annotation will ignore those fields
@JsonIgnoreProperties(ignoreUnknown=true)
public class LaunchApp {
	
	
	public static void main(String[] args) throws IOException {
		
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
		
		
		// Below we are reading JSON file and converting it to Java obejct
		StudentModel student4 = mapper.readValue(new File("json/sudentModel.json"), StudentModel.class);
		System.out.println(student4);
		
	}

}
