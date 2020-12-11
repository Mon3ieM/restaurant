package com.restaurant.model.control;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.restaurant.model.eo.Clients;
import com.restaurant.model.eo.Orders;
import com.restaurant.model.eo.Users;
import com.restaurant.model.services.OrdersService;

@Controller
public class AssignDeliveryControl {

	public Orders renderOrder=new Orders();
	public Orders or=new Orders();
	public String msg = "";
	public List<Users> delivery=new ArrayList<>();
	@Autowired
	private OrdersService serv;

	@RequestMapping("/findOrder")
	public ModelAndView DeliveryAssign() {
		ModelAndView mv = new ModelAndView("AssignDelivery");
		mv.addObject("or", or);
		mv.addObject("delivery", delivery);
		return mv;

	}

	
	@RequestMapping(value = "/findOrderByID", method = RequestMethod.POST)
	public String findOrderByID(@ModelAttribute("order") Orders order) {
		System.out.println(order.getId());
		renderOrder=serv.getAllData(order.getId());
		if (renderOrder != null) {
			System.out.println(renderOrder.getClients().getName());
			or = renderOrder;
			msg = "";
		} else {
			or = new Orders();
			msg = "الاوردر غير موجود";
		}
		return "redirect:/findOrder";
	}

}
