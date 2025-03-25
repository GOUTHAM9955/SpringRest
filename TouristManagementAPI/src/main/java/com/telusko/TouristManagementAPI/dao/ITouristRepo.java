package com.telusko.TouristManagementAPI.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.telusko.TouristManagementAPI.model.Tourist;

public interface ITouristRepo extends JpaRepository<Tourist, Integer> 
{

}
