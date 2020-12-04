package com.restaurant.model.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.restaurant.model.eo.Users;
import com.restaurant.model.services.UsersService;

@Controller

public class HomeControl {
	@Autowired
	private UsersService userServ;
	
	@RequestMapping("/loadData")
	public String viewHomePage(Model model) {
		System.out.println("TEST .............. ");
		//Users userDTO = new Users();
	    //model.addAttribute("user", userDTO);
	     
	    return "dashboards";
	}
	
	
}
