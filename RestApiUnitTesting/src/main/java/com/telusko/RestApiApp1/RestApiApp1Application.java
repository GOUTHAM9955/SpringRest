package com.telusko.RestApiApp1;

//IN THIS PROJECT WE ARE GOING TO CONCENTRATE ON UNIT TESTING ON REST API
/*
 * Unit testing is a bit different in REST API's as the methods will be invoked by dispatcher servlet upon web requests
 * 		So we have to create fake request	
 * 
 * Spring boot by default have Junit5 and Mockito
 * 	....CHECK TEST CLASSES
 * 
 */

// Junit VS Mockito
/*
 * Junit:
 * 	•	Verify that individual units of your code (e.g., methods or classes) work as expected.
	•	Ensures code correctness by running automated tests.
	
	Mockito:
	•	Simulate the behavior of external dependencies (e.g., services, repositories, etc.).
	•	Isolate the class under test by mocking dependencies.
 */
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestApiApp1Application {

	public static void main(String[] args) {
		SpringApplication.run(RestApiApp1Application.class, args);
	}

}
