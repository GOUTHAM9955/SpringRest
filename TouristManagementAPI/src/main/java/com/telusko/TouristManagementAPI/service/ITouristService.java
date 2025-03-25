package com.telusko.TouristManagementAPI.service;

import java.util.List;

import com.telusko.TouristManagementAPI.exception.TouristNotFoundException;
import com.telusko.TouristManagementAPI.model.Tourist;

public interface ITouristService
{
	String registerTourist(Tourist tourist);
	Tourist fetchTouristById(Integer id) throws TouristNotFoundException ;
	List<Tourist> fetchAllTouristInfo();
	String updateTheTouristInfo(Tourist tourist);
	String updateTheTouristBudget(Integer id, Double budget);
	String deleteTouristInfoById(Integer id);

}
