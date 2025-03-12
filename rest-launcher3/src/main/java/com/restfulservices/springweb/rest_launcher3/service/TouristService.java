package com.restfulservices.springweb.rest_launcher3.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restfulservices.springweb.rest_launcher3.dao.ITouristRepo;
import com.restfulservices.springweb.rest_launcher3.exception.TouristNotFoundException;
import com.restfulservices.springweb.rest_launcher3.model.Tourist;

@Service
public class TouristService implements ITouristService {
	
	@Autowired
	ITouristRepo touristRepo;

	@Override
	public String registerTourist(Tourist tourist) {
		return "Sucessfully registered with tourist Id" + touristRepo.save(tourist).getId();
	}
 
	@Override
	public Tourist touristById(Integer id) throws TouristNotFoundException {
		
		
		/*Optional<Tourist> tourist = touristRepo.findById(id);
		if(tourist.isPresent())
		{
			return tourist.get();
		}
		else {
			throw new TouristNotFoundException("There isn't any tourist by this ID");
		}
		*/
		
		// RECOMMENDED METHOD
	        return touristRepo.findById(id)
	                .orElseThrow(() -> new TouristNotFoundException("There isn't any tourist by this ID"));
	    
	}

	@Override
	public List<Tourist> fetchTourists() {
		// TODO Auto-generated method stub
		return touristRepo.findAll();
	}
	
	@Override
	public String updateTourist(Tourist tourist) {
		Optional<Tourist> record = touristRepo.findById(tourist.getId());
		if(record.isPresent()) {
			touristRepo.save(tourist);
			return "Tourist sucessfully registered";
	}
		else {
			throw new TouristNotFoundException("There isn't any tourist by this ID");
		}
}

	@Override
	public String updateTouristBudget(Integer id, Double budget) {
		
		Optional<Tourist> record = touristRepo.findById(id);
		if(record.isPresent()) {
			record.get().setBudget(budget);
			touristRepo.save(record.get());
			return "Budget sucessfully updated";
	}
		else {
			throw new TouristNotFoundException("There isn't any tourist by this ID");
		}
	}

	@Override
	public String deleteById(Integer id) {
		Optional<Tourist> record = touristRepo.findById(id);
		if(record.isPresent()) {
			touristRepo.deleteById(id);
			return "Record sucessfully deleted";
	}
		else {
			throw new TouristNotFoundException("There isn't any tourist by this ID");
		}
	}
	
}
