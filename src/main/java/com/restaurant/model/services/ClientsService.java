package com.restaurant.model.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restaurant.model.eo.Clients;
import com.restaurant.model.eo.Orders;
import com.restaurant.model.repository.ClientsRepository;

@Service
@Transactional
public class ClientsService {

	@Autowired
	ClientsRepository repo;
	public List<Clients> listAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}


	public void save(Clients eo) {
		// TODO Auto-generated method stub
		repo.save(eo);
	}

	public Clients get(Long id) {
		// TODO Auto-generated method stub
	return	repo.getOne(id);
	}

	public void delete(Long id) {
		repo.deleteById(id);
		
	}
}
