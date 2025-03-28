package com.telusko.RestApiApp1.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.telusko.RestApiApp1.model.Student;

@RestController
@RequestMapping("api2")
public class StudentController 
{
	@GetMapping("/info1")
   public ResponseEntity<Student> studentInfo()
   {
	   Student st=new Student(1,"Rohan", "Bengaluru");
	   return new ResponseEntity<Student>(st,HttpStatus.OK);
   }
	@GetMapping("/info2")
	 public Student studentInfo2()
	 {
		  Student st=new Student(1,"Rohan", "Bengaluru");
		  return st;
	 }
	
	@PostMapping("/add")
	public String addStudent(@RequestBody Student data)
	{
		  System.out.println(data);
		  return "Data saved";
	}
}
