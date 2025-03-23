package com.telusko.TicketBookingWEBAPP;

/*
 * Things we are going to look at is
 *   	1) RestTemplate
 *      2) WebClient
 *      3) SwaggerAPI for documentation
 *      
 * In this project we are going to develop front end application which in turn talks with TicketBookingAPP application 
 *    
 * >>For dynamic UI pages we used thymeleaf(which is a java based server side templating engine used to build dynamic web applications. 
 * 	 It integrates easily with Spring Boot and allows you to create HTML pages with embedded Java expressions, 
 * 	 making it a popular choice for MVC applications. 
 *    	  
 *    We added the necessary dependency in pom.xml
 *    We created required HTML pages in templates folder under resources 
 * 
 */

//REST TEMLATE and WEB CLIENT
// check TicketService class


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TicketBookingWebappApplication {

	public static void main(String[] args) {
		SpringApplication.run(TicketBookingWebappApplication.class, args);
	}

}
