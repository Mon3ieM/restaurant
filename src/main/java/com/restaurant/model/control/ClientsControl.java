package com.restaurant.model.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.restaurant.model.eo.Clients;
import com.restaurant.model.eo.Users;
import com.restaurant.model.services.ClientsService;

@Controller
public class ClientsControl {

	@Autowired
	ClientsService clientServ;
	
	
	@RequestMapping(value = "/findByMobile1", method = RequestMethod.POST)
	public String saveProduct(@ModelAttribute("mobile1") String mobile1) {
	  String redirectTo = null;
	List<Clients> findClients =	clientServ.findbyMobile1(mobile1);
	
	if(!findClients.isEmpty()) {
		Clients cl  = findClients.get(0);
		redirectTo  = "clientFound";
	}else
		redirectTo  = "clientNotFound";
	     
	    return "redirectTo";
	}
}
