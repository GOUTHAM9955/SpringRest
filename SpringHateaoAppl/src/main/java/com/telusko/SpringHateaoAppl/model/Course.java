package com.telusko.SpringHateaoAppl.model;

import org.springframework.hateoas.RepresentationModel;

public class Course extends RepresentationModel
{
	private Integer cid;
	
	private String name;
	
	private Double cost;

	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getCost() {
		return cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}

	@Override
	public String toString() {
		return "Course [cid=" + cid + ", name=" + name + ", cost=" + cost + "]";
	}

	public Course(Integer cid, String name, Double cost) {
		super();
		this.cid = cid;
		this.name = name;
		this.cost = cost;
	}

	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
