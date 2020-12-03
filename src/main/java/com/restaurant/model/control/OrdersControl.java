package com.restaurant.model.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.restaurant.model.eo.Orders;
import com.restaurant.model.eo.Users;
import com.restaurant.model.services.OrdersService;
import com.restaurant.model.services.UsersService;

@Controller
public class OrdersControl {

	@Autowired
	private OrdersService serv;
	@Autowired
	private UsersService userServ;
	
	@RequestMapping("/")
	public String viewHomePage(Model model) {
		System.out.println("TEST .............. ");
	    List<Orders> listOrders = serv.listAll();
	    model.addAttribute("listOrders", listOrders);
	     
	    return "index";
	}
	
	@RequestMapping("/loginAction/{data}")
	public ModelAndView loginAction(@PathVariable(name = "username") String username , @PathVariable(name = "password") String password) {
		ModelAndView mav = new ModelAndView("homepage");
		Users loggedUser = userServ.findByUsernameAndPassword(username, password);
		if(loggedUser != null && loggedUser.getIsActive().equals(1L))
			mav.addObject("loggedUser", loggedUser);
	     
	    return mav;
	}
	
}
