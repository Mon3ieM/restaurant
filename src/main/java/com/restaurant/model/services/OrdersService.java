package com.restaurant.model.services;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restaurant.model.eo.Orders;
import com.restaurant.model.repository.OrdersRepository;

@Service
@Transactional
public class OrdersService{
	@Autowired
	private OrdersRepository repo;

	public List<Orders> listAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}


	public void save(Orders eo) {
		// TODO Auto-generated method stub
		repo.save(eo);
	}

	public Orders get(Long id) {
		// TODO Auto-generated method stub
	return	repo.getOne(id);
	}

	public void delete(Long id) {
		repo.deleteById(id);
		
	}
	
	
	
}
