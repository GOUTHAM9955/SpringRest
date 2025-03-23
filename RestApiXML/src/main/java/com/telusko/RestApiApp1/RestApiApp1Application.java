package com.telusko.RestApiApp1;
// IN THIS PROJECT WE ARE GOING TO SEE HOW WE CAN BIND XML DATA TO JAVA OBJECT 
//ADD JAXONXML DEPENDENCIES (JACKSON-DATAFORMAT-XML AND JACKSON-CORE)
// CHECK CONTROLLER CLASS MODEL CLASS
// CHECK MODEL CLASS ADNNOTATAED WITH @JacksonXmlRootElement
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@SpringBootApplication
public class RestApiApp1Application {

	public static void main(String[] args) {
		SpringApplication.run(RestApiApp1Application.class, args);
	}

}
