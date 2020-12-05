
package com.restaurant.model.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.restaurant.model.eo.FoodMenu;
import com.restaurant.model.eo.Orders;
import com.restaurant.model.repository.FoodMenuRepository;

@Service
@Transactional
public class FoodMenuService {
	
	@Autowired
	FoodMenuRepository repo;

	
	
	public void save(FoodMenu eo) {
		// TODO Auto-generated method stub
		repo.save(eo);
	}
	

	
	public List<FoodMenu> listAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}




	public FoodMenu get(Long id) {
		// TODO Auto-generated method stub
	return	repo.getOne(id);
	}

	public void delete(Long id) {
		repo.deleteById(id);
		
	}
}
