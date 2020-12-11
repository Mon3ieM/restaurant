package com.restaurant.model.services;

import java.util.List;

import javax.swing.border.AbstractBorder;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restaurant.model.eo.FoodMenu;
import com.restaurant.model.eo.FoodPrices;
import com.restaurant.model.eo.Orders;
import com.restaurant.model.repository.ClientsRepository;
import com.restaurant.model.repository.FoodMenuRepository;
import com.restaurant.model.repository.FoodPriceRepository;
import com.restaurant.model.repository.OrderItemsRepository;
import com.restaurant.model.repository.OrdersRepository;

@Service
@Transactional
public class OrdersService {
	@Autowired
	private OrdersRepository repo;

	@Autowired
	private OrderItemsRepository orderItemRepo;

	@Autowired
	private FoodPriceRepository foodPriceRepo;

	@Autowired
	private ClientsRepository clientRepo;

	public FoodPrices getFoodPrice(Long foodMenuId, Long foodSizeId) {
		// TODO Auto-generated method stub
		return foodPriceRepo.getPriceForSelectedMenuItemPerSize(foodMenuId, foodSizeId);
	}

	public void createNewOrder(Orders eo) {
		// TODO Auto-generated method stub
		repo.save(eo);
	}

	public Orders getAllData(Long id) {
		Orders order = repo.getOne(id);
		order.setClients(clientRepo.getOne(order.getClientId()));
		return order;
	}

	public List<Orders> listAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	public Orders get(Long id) {
		// TODO Auto-generated method stub
		return repo.getOne(id);
	}

	public void delete(Long id) {
		repo.deleteById(id);

	}

}
