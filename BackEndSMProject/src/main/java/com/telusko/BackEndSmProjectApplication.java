package com.telusko;
// THIS PROJECT WE ARE GOING TO CHECK HOW TO CONNECT WITH CROSS ORIGIN SYSTEMS (To connect spring boot application with React/ NodeJs etc...)

/* We used cross origin annotation (@CrossOrigin) on our controller class to connect with cross origin system
 *		..... CHECK CONTROLLER CLASS
Sample React Code : //https://github.com/Gaurav560/student-management-system-frontend
 Steps to run react application:
 	npm i
	npm install axios
	npm install react-router-dom
	npm run dev

If we have multiple controller class we can have a common @Cofiguration component class and do the configurations over there
		..... CHECK WebMvcConfiguration Class
	
 */



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BackEndSmProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackEndSmProjectApplication.class, args);
	}
	

}
