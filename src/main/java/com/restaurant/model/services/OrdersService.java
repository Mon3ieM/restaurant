package com.restaurant.model.services;

<<<<<<< HEAD
import java.math.BigDecimal;
import java.math.BigInteger;
=======
>>>>>>> 95427e7b70ec812f9d113fa19c90a374f0daabc9
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

<<<<<<< HEAD
import com.restaurant.model.dto.ReportMenuDataQtyDTO;
=======
>>>>>>> 95427e7b70ec812f9d113fa19c90a374f0daabc9
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

<<<<<<< HEAD
	public List<ReportMenuDataQtyDTO> getMenuQtyReportDate(Date date_From, Date date_To) {

		List<ReportMenuDataQtyDTO> res = new ArrayList<ReportMenuDataQtyDTO>();

		List<Object[]> resObj = repo.getReportData(date_From, date_To);
		for (Object[] data : resObj) {

			ReportMenuDataQtyDTO resDTO = new ReportMenuDataQtyDTO();

			resDTO.setQty((BigDecimal) data[0]);
			resDTO.setSizeId((BigInteger) data[1]);
			resDTO.setItemname((String) data[2]);
			resDTO.setPrice((BigInteger) data[3]);
			resDTO.setTotal((BigDecimal) data[4]);

			res.add(resDTO);
		}

		return res;
	}

=======
>>>>>>> 95427e7b70ec812f9d113fa19c90a374f0daabc9
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
<<<<<<< HEAD

	public List<Orders> getOrdersFromToByDeliveryID(String from, String to, String deliveryId) throws ParseException {
		List<Orders> orderss = new ArrayList<Orders>();

		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH);
		Date FromDate = format.parse(from + " 03:00:00");
		Date ToDate = format.parse(to + " 03:00:00");

		System.err.print("--------------------" + FromDate + "--------------------");
		orderss = repo.getOrderFromToDateByDeliveryID(FromDate, ToDate, Long.parseLong(deliveryId));
		System.err.print("--------------------" + orderss.size() + "--------------------");

		return orderss;
	}

	public List<Orders> getOrdersFromToByCasherID(String from, String to, String casherId) throws ParseException {
		List<Orders> orderss = new ArrayList<Orders>();

		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH);
		Date FromDate = format.parse(from + " 03:00:00");
		Date ToDate = format.parse(to + " 03:00:00");

		System.err.print("--------------------" + FromDate + "--------------------");
		orderss = repo.getOrderFromToDateByCasherID(FromDate, ToDate, Long.parseLong(casherId));
		System.err.print("--------------------" + orderss.size() + "--------------------");

		return orderss;
	}

	public List<Orders> getOrdersFromTo(String from, String to) throws ParseException {
		List<Orders> orderss = new ArrayList<Orders>();

		DateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
		Date FromDate = format.parse(from);
		Date ToDate = format.parse(to);

		System.err.print("--------------------" + FromDate + "--------------------");
		orderss = repo.getOrderFromToDate(FromDate, ToDate);
		System.err.print("--------------------" + orderss.size() + "--------------------");
=======
	
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
>>>>>>> 95427e7b70ec812f9d113fa19c90a374f0daabc9

		return orderss;
	}

	public Long getAllAmount() {
		Long totalAmount = 0L;

		try {
<<<<<<< HEAD

			Date today = JavaUtils.getToday();
			Date tomorrow = JavaUtils.getTomorrow();
			System.err.println(today + " --- " + tomorrow);
			totalAmount = repo.getTotalAmount(today, tomorrow);
=======
			
			Date today = JavaUtils.getToday();
			Date yesterday = JavaUtils.getYesterday();
			System.err.println(today + " --- "+ yesterday);
			totalAmount = repo.getTotalAmount(yesterday , today);
>>>>>>> 95427e7b70ec812f9d113fa19c90a374f0daabc9
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

<<<<<<< HEAD
	}

	public void update(Orders eo) {
		repo.save(eo);
	}

=======
	}

	public void update(Orders eo) {
		repo.save(eo);
	}

>>>>>>> 95427e7b70ec812f9d113fa19c90a374f0daabc9
}
