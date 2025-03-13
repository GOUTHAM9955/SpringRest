package com.restfulservices.springweb.rest_launcher3.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restfulservices.springweb.rest_launcher3.model.Tourist;

public interface ITouristRepo extends JpaRepository<Tourist, Integer>{
	
	
}
