package com.restaurant.model.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
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
		Users userDTO = new Users();
	    model.addAttribute("user", userDTO);
	     
	    return "popup";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveProduct(@ModelAttribute("user") Users user) {
	   
	Users us = userServ.findByUsernameAndPassword(user.getUserName(), user.getPassword());
	
	System.err.print(us.getId());
	     
	    return "redirect:/";
	}

	
}
