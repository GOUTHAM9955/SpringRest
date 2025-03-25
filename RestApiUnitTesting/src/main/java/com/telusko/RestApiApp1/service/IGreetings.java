package com.telusko.RestApiApp1.service;

import com.telusko.RestApiApp1.model.Student;


public interface IGreetings
{
	
	String generateWish(String name);
	Boolean addStudent(Student st);

}
