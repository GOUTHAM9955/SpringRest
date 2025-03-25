package com.telusko.TouristManagementAPI;

// In this project we are going to discuss about
		//SCOPES
		// application.yml 
		// HTTP Request & HTTP Response 
	

//SCOPES
/* Revision : Spring Boot's default IOC container is Application context which follows Eager Loading
 * In spring boot supports 4 different beans
 * 	>> Singleton
 * 		It follows EagerLoading 
 * 		Default Scope of all the Beans is Singleton
 * 		One Bean will get created for IOC container irrespective of number of times it is used
 * 	>> Prototype
 * 		The are two ways of declaring it, check service class
 *             @Scope("prototype")
 *			  //@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
 * 		 It is Lazy Loading 
 * 	     Each time we perform dependency Injection, new Bean will get created for IOC container
 *		
 * WE APPLY Request and Session SCOPES TO OUR CONTROLLER
 * 	>> Request 
 * 		It supports lazy loading, Bean will get created only when there is HTTP request
 * 		In this case if a single user is making 100 requests to application 100 Beans will get created
 * 		
 * 	>> Session
 * 		Normally when a user hit's an end point a sessionId will get created for 1st time and going forward for all the following request same sessionId will be used
 * 		
 * 		If we are making the scope as session, it supports Lazy Initialization 
 * 		Bean will be created upon 1st HTTP request to application and irrespective of how many requests made only one Bean per session will be used	
 */

//application.yml 
/*
 * application.properties is specific to Spring Boot applications while application.yml is universal format can be used to configure application properties in any framework
 * 
 * application.yml is an alternative to application.properties in Spring Boot for configuring the application.
	•	It uses the YAML format, which is:
	•	More readable for nested and structured configurations.
	•	Uses key-value pairs with indentation (instead of = like in .properties).
 * 	•	Spring Boot automatically loads both .properties and .yml files from src/main/resources.
	•	For simple apps, .properties is fine. For complex apps, YAML is preferable.
	
	Application.properties :
			server.port=8080
			spring.datasource.url=jdbc:mysql://localhost:3306/mydb
			spring.datasource.username=root
			spring.datasource.password=pass
			spring.jpa.hibernate.ddl-auto=update
			spring.jpa.show-sql=true
	application.yml	Sample Syntax:
				server:
				  port: 8080
				
				spring:
				  datasource:
				    url: jdbc:mysql://localhost:3306/mydb
				    username: root
				    password: pass
				  jpa:
				    hibernate:
				      ddl-auto: update
				    show-sql: true
 */

//HTTP Request & HTTP Response
/*
 * HTTP Request consists of:
 * 		1) Request URL(request type)  
 * 		2) Request Header (meta data)
 * 		3) Request Body(pay load)
 * 
 * HTTP Response:
 * 		1) Response Line(Status code && Status message)
 * 		2) Response Header(meta data)
 * 		3) Response Body(Pay load)
 * 
 * HTTP Status Codes:
 * 	 Success -> OK -> 200 - 299(2xx) 
 * 	 Client Error -> Bad Request -> 400-499(4xx)	
 *   Server side Error -> 500 - 599(5xx)
 *   Informational(While the request is still in process) -> 100-199(1xx)
 *   Redirection -> 300 -399(3xx)
 *   
 *  WE USE ResponseEntity OBJECTS TO WRAP ALL THIS DATA ALONG WITH PAY LOAD 
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Scope;

@SpringBootApplication
public class TouristManagementApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(TouristManagementApiApplication.class, args);
	}

}
