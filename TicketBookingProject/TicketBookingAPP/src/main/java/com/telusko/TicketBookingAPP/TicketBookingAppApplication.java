package com.telusko.TicketBookingAPP;

/*
 * Things we are going to look at is
 *   	1) RestTemplate
 *      2) WebClient
 *      3) SwaggerAPI for documentation
 *      
 *  We are developing 2 applications
 *  	1) WebApp will take passenger info returns ticket by contacting ticket booking application (client -> Business)
 *      2) Ticket Booking application which actually books the ticket from the passenger info passed from webapp  (Business -> Business)
 *      
 *  This project particularly focuses on Ticket Booking Application
 *  
 *  >> To document we are using SWAGGER API for which we are using the following annotation >> (@OpenAPIDefinition)
 *     I added the dependency manually in pom.xml file
 *  		I added info in the documentation and server information using predefined annotations form swagger API
 *  		I added specific information at controller level using @Tag annotation 
 *  		I added specific information at end point using @Operation annotation
 *     Now after deploying the application if we got to : http://localhost:8485/TicketBookingAPI/swagger-ui/index.html
 *     		We can find all the info mentioned using swagger API along with request details and test all the API's
 *       
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;

@SpringBootApplication
@OpenAPIDefinition(
		info=@Info(
				title="TicketBooking API",
				version="v1.0",
				description="This API will Book and Generate Ticket"
				),
		servers=@Server(
				url="http://localhost:8485/TicketBookingAPI",
				description="This API is deployed in the followed url"
				)
		
		)
public class TicketBookingAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(TicketBookingAppApplication.class, args);
	}

}
