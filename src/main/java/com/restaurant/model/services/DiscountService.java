package com.restaurant.model.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restaurant.model.eo.Clients;
import com.restaurant.model.eo.Discount;
import com.restaurant.model.repository.ClientsRepository;
import com.restaurant.model.repository.DiscountRepository;
@Service
@Transactional
public class DiscountService {


		@Autowired
		DiscountRepository repo;
		public List<Discount> listAll() {
			// TODO Auto-generated method stub
			return repo.findAll();
		}


		public void save(Discount eo) {
			// TODO Auto-generated method stub
			repo.save(eo);
		}

		public Discount get(Long id) {
			// TODO Auto-generated method stub
		return	repo.getOne(id);
		}

		public void delete(Long id) {
			repo.deleteById(id);
			
		}
}
