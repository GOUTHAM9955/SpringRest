package com.telusko.SpringHateaoAppl.rest;
/*
 * We use WebMvcLinkBuilder to build these ref urls
 * 
 * We extended Model class(Course) with RepresentationModel to add link to Model Object 
 */
import java.util.ArrayList;
import java.util.List;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.telusko.SpringHateaoAppl.model.Course;

@RestController
public class CourseController
{
	@GetMapping("/course-info")
	public ResponseEntity<Course> getCourseInfo()
	{
		Course course=new Course(1,"DevOps with AWS", 9999.8);
		
		// CODE TO ADD LINK
		Link link = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder
				.methodOn(CourseController.class).getAllCourseInfo()).withRel("Get All Course");
		
		
		course.add(link);
		return new ResponseEntity<Course>(course, HttpStatus.OK);
	}
	
	@GetMapping("/all-course-info")
	public ResponseEntity<List> getAllCourseInfo()
	{
		Course course1=new Course(1,"DevOps with AWS", 9999.8);
		Course course2=new Course(2,"DevOps", 999.8);
		Course course3=new Course(3,"AWS", 9999.8);
		
		List<Course>courses=new ArrayList<>();
		courses.add(course1);
		courses.add(course2);
		courses.add(course3);
		
		return new ResponseEntity<List>(courses, HttpStatus.OK);
	}

}
