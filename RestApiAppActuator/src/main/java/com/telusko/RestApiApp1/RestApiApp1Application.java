package com.telusko.RestApiApp1;
// IN THIS PROJECT WE ARE GOING TO DISCUSS ABOUT ACTUATOR'S
/*Spring Boot Actuator is a production-ready feature that helps you monitor and manage your Spring Boot application by exposing RESTful endpoints(These endpoints are predefined).
 		
•	Provides real-time insights into your application’s health, metrics, and configurations.
•	Simplifies application monitoring without additional dependencies.
•	Supports integration with external monitoring systems (e.g., Prometheus, Grafana)
*/

// STEP TO CONFIGURE
/*
 * We needs to add a dependency for this which is Spring Boot Actuator
 * 
 * We need to enable few endpoints using application.properties
 * 		management.endpoints.web.exposure.include=* >> This Enable all endpoints, by default only health endpoint is enabled if we don't specify this
 			{to check what all endpoints are enabled we can use https://localhost:port/actuator}
 			
		management.endpoints.web.exposure.exclude=env,beans  >> If you want to disable few endpoints in specific
		
		management.endpoint.shutdown.enabled=true >> If we want to shut down application 
		
		// All the requests are get request except shut down request which is POST and this we have to enable manually if we want to use it.
		    It isn't part of 1st property
		
		
 * 
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestApiApp1Application {

	public static void main(String[] args) {
		SpringApplication.run(RestApiApp1Application.class, args);
	}

}
