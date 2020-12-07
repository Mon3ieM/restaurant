package com.restaurant.model.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.restaurant.model.eo.Clients;
import com.restaurant.model.eo.Users;
import com.restaurant.model.services.UsersService;

@Controller

public class HomeControl {
		
	@RequestMapping("/HomePage")
	public String viewHomePage(Model model) {
		System.out.println("TEST .............. ");
	    return "homePage";
	}
	@RequestMapping("/ClientsHomePage/{type}")	
	public ModelAndView DeliveryHomePage(@PathVariable(name = "type") int type) {
		ModelAndView mv=new ModelAndView("Clients");
		mv.addObject("NewCL", new Clients());
		mv.addObject("cl", new Clients());
		mv.addObject("msg", "");
		System.out.println(type + ".............. ");
	    
		System.out.println("TEST .............. ");
	    return mv;
	}
	
	
	
	
}
