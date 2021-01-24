package com.restaurant.model.services;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

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
import com.restaurant.utils.JavaUtils;

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
		if (order != null && order.getClientId() != null) {
			order.setClients(clientRepo.getOne(order.getClientId()));
		}
		return order;
	}

	public Orders getAllData(Long id) {
		Orders order = repo.getOne(id);

		order.setClients(clientRepo.getOne(order.getClientId()));

		return order;
	}
	
	public List<Orders> getOrdersFromToByDeliveryID(String from,String to,String deliveryId) throws ParseException {
		List<Orders> orderss=new ArrayList<Orders>();
	    
	    DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH);
	    Date FromDate = format.parse(from+ " 03:00:00");
	    Date ToDate = format.parse(to+ " 03:00:00");

		System.err.print("--------------------"+FromDate + "--------------------");
		orderss = repo.getOrderFromToDateByDeliveryID(FromDate, ToDate, Long.parseLong(deliveryId));
		System.err.print("--------------------"+orderss.size() + "--------------------");

		return orderss;
	}
	
	public List<Orders> getOrdersFromToByCasherID(String from,String to,String casherId) throws ParseException {
		List<Orders> orderss=new ArrayList<Orders>();
	    
	    DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH);
	    Date FromDate = format.parse(from+ " 03:00:00");
	    Date ToDate = format.parse(to+ " 03:00:00");

		System.err.print("--------------------"+FromDate + "--------------------");
		orderss = repo.getOrderFromToDateByCasherID(FromDate, ToDate, Long.parseLong(casherId));
		System.err.print("--------------------"+orderss.size() + "--------------------");

		return orderss;
	}

	public Long getAllAmount() {
		Long totalAmount = 0L;

		try {
			
			Date today = JavaUtils.getToday();
			Date yesterday = JavaUtils.getYesterday();
			System.err.println(today + " --- "+ yesterday);
			totalAmount = repo.getTotalAmount(yesterday , today);
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
