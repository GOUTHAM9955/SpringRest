package com.telusko.RestApiApp1.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

//@XmlRootElement
@JacksonXmlRootElement
public class Course 
{
	private Integer id;
	
	private String course;
	
	private String duration;
	
	private Double cost;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public Double getCost() {
		return cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}

	public Course(Integer id, String course, String duration, Double cost) {
		super();
		this.id = id;
		this.course = course;
		this.duration = duration;
		this.cost = cost;
	}

	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", course=" + course + ", duration=" + duration + ", cost=" + cost + "]";
	}
	
	
}
