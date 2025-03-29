package com.telusko.SpringHateaoAppl;
//IN THIS PROJECT WE ARE GOING TO IMPLEMENT HATEOAS
/*
 * 	•	HATEOAS is used to create rich, navigable REST APIs by providing hypermedia links to guide the client on how to interact with the API.
	•	It allows the API to include relevant links in the responses, making it self-discoverable and reducing the need for clients to hardcode URLs.
	
	To implement HATEOS we have add HATEOAS dependency
	
	CHECK CONTROLLER CLASS
 */


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringHateaoApplApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringHateaoApplApplication.class, args);
	}

}
