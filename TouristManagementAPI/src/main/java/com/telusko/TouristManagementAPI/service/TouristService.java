package com.telusko.TouristManagementAPI.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.telusko.TouristManagementAPI.dao.ITouristRepo;
import com.telusko.TouristManagementAPI.exception.TouristNotFoundException;
import com.telusko.TouristManagementAPI.model.Tourist;
@Service
@Scope("prototype")
//@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class TouristService implements ITouristService
{
	@Autowired
	private ITouristRepo repo;
	
	public TouristService()
	{
		System.out.println("TouristService bean created");
	}
	

	@Override
	public String registerTourist(Tourist tourist) 
	{
		Tourist tour = repo.save(tourist);
		return "Tourist Info Registered with id "+tour.getId();
	}

	@Override
	public Tourist fetchTouristById(Integer id) throws TouristNotFoundException  {
//		Optional<Tourist> optional = repo.findById(id);
//		if(optional.isPresent())
//			return optional.get();
//		else
//			throw new TouristNotFoundException("Tourist with given id not found");
		
		return repo.findById(id).orElseThrow(()-> new TouristNotFoundException("Tourist with given id not found"));
	}

	@Override
	public List<Tourist> fetchAllTouristInfo() {
	
		return repo.findAll();
	}

	@Override
	public String updateTheTouristInfo(Tourist tourist) 
	{
		Optional<Tourist> optional = repo.findById(tourist.getId());
		if(optional.isPresent())
		{
//			Tourist trst = optional.get();
			repo.save(tourist);
			return "Tourist info is udpated successfully";
		}
		else
		{
			throw new TouristNotFoundException("Tourist with given info not found for updation");
		}
	}

	@Override
	public String updateTheTouristBudget(Integer id, Double budget)
	{
		Optional<Tourist> optional = repo.findById(id);
		if(optional.isPresent())
		{
			Tourist tourist = optional.get();
			tourist.setBudget(budget);
			repo.save(tourist);
			return "Tourist info is udpated successfully";
		}
		else
		{
			throw new TouristNotFoundException("Tourist with given info not found for updation");
		}
	}

	@Override
	public String deleteTouristInfoById(Integer id)
	{
		Optional<Tourist> optional = repo.findById(id);
		if(optional.isPresent())
		{
			repo.deleteById(id);
			return "Tourist record deleted with id "+ id;
		}
			else
			{
				throw new TouristNotFoundException("Tourist with given info not found for Deletion");
			}
	}

}
