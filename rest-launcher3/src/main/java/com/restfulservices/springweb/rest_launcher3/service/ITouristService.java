package com.restfulservices.springweb.rest_launcher3.service;

import java.util.List;

import com.restfulservices.springweb.rest_launcher3.exception.TouristNotFoundException;
import com.restfulservices.springweb.rest_launcher3.model.Tourist;

public interface ITouristService {
	public String registerTourist(Tourist tourist);
	public Tourist touristById(Integer id) throws TouristNotFoundException;
	public List<Tourist> fetchTourists();
	
	public String updateTourist(Tourist tourist);
	public String updateTouristBudget(Integer id, Double budget);
	public String deleteById(Integer id);
	
}
