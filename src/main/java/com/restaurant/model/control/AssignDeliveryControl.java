package com.restaurant.model.control;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.reports.report;
import com.restaurant.model.eo.Clients;
import com.restaurant.model.eo.Orders;
import com.restaurant.model.eo.Users;
import com.restaurant.model.services.OrdersService;
import com.restaurant.model.services.UsersService;

@Controller
public class AssignDeliveryControl {

	public Orders renderOrder = new Orders();
	public Orders or = new Orders();
	public String msg = "";
	public List<Users> delivery = new ArrayList<Users>();

	@Autowired
	private OrdersService serv;

	@Autowired
	private UsersService userserv;

	@RequestMapping("/findOrder")
	public ModelAndView DeliveryAssign() {
		delivery = userserv.findByRoleId(3L);

		ModelAndView mv = new ModelAndView("AssignDelivery");
		mv.addObject("or", or);
		mv.addObject("delivery", delivery);
		mv.addObject("msg", msg);
		return mv;

	}

	@RequestMapping(value = "/findOrderByID", method = RequestMethod.POST)
	public String findOrderByID(@ModelAttribute("order") Orders order) {
		if (order.getId() != null) {
			System.out.println("insid Control");
			renderOrder = serv.getDeliverOrderAllData(order.getId());
			if (renderOrder != null && renderOrder.getId() != null) {
				System.out.println("insid Control FOund" + renderOrder.getClients().getName());
				or = renderOrder;
				msg = "";
			} else {
				System.out.println("insid Control No Found");
				or = new Orders();
				msg = "الاوردر غير موجود";
			}
		} else {

			or = new Orders();
			msg = "الاوردر غير موجود";
		}
		return "redirect:/findOrder";
	}

	@PostMapping(value = "/AddDelivery")
	public String AddDelivery(@ModelAttribute("Users") Users u) {
		System.out.println(u.getId());
		if (or.getId() != null) {
			or.setDeliveryId(u.getId());
			serv.update(or);
			msg = "تم التعين بنجاح";
		}
		return "redirect:/findOrder";
	}

}
