package com.restfulservices.springweb.rest_launcher3.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Tourist {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Integer id;
	String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	String city;
	String packageType;
	Double budget;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPackageType() {
		return packageType;
	}
	public void setPackageType(String packageType) {
		this.packageType = packageType;
	}
	public Double getBudget() {
		return budget;
	}
	public void setBudget(Double budget) {
		this.budget = budget;
	}
	public Tourist(Integer id,String name, String city, String packageType, Double budget) {
		super();
		this.name =name;
		this.id = id;
		this.city = city;
		this.packageType = packageType;
		this.budget = budget;
	}
	public Tourist() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Tourist [id=" + id + ", name=" + name + ", city=" + city + ", packageType=" + packageType + ", budget="
				+ budget + "]";
	}
	
	
}
