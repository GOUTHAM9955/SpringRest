package com.telusko.RestApiApp1;
 // In this project we are going to explore how we can configure multiple environment properties(using application.properties) using SpringBoot Profiles

/*
 * We created multiple applicaiton.properties following the syntax application- +"environment".properties
 * 
 * In application.properties we have below code:
 * 		spring.profiles.active=prod // to make it as default profile
		spring.profiles.include=sb,boot // Make it inclusive in all the environments... check SpringBoot.java, we used @Profiles annotation  
		
		If we want to include that Bean in all the environment we usually use it
		
		We also can use @Primary annotation on the Component classes instead of spring.profiles.include but when you have both, 
			spring.profiles.include will have lesser priority 
		
		

 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.telusko.RestApiApp1.service.ICourse;

@SpringBootApplication
public class RestApiApp1Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext container = SpringApplication.run(RestApiApp1Application.class, args);
	ICourse course = container.getBean(ICourse.class);
	course.getTheCourse(555.5);
	}

}
