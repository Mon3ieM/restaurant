package com.restaurant.model.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

	public Orders getDeliverOrderAllData(Long id) {
		Orders order = repo.getDeliveryOrders(id);
		System.out.println(id + "______");
		if (order != null && order.getClientId() != null) {
			System.out.println(order.getClientId() + "______");
			order.setClients(clientRepo.getOne(order.getClientId()));
		}
		return order;
	}

	public Orders getAllData(Long id) {
		Orders order = repo.getOne(id);
		
		order.setClients(clientRepo.getOne(order.getClientId()));
		
		return order;
	}
	public Long getAllAmount( ) {
		System.out.println("test------------------");
		Long totalAmount = 0L;
	
		try {
		    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
		    String strDate= formatter.format(new Date());  
		    Date date;
			date = formatter.parse(strDate);
			totalAmount = repo.getTotalAmount(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return totalAmount;
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

	public void update(Orders eo) {
		repo.save(eo);
	}

}
