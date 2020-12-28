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
import com.restaurant.utils.SessionData;

@Controller
public class HomeControl {

	@Autowired
	private SessionData sessionData;
	
	
	
	@RequestMapping("/HomePage")
	public ModelAndView viewHomePage(Model model) {
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("sessionData", sessionData);
		
		return mv;
	}
	


	@RequestMapping("/homePageFilter/{type}")
	public String DeliveryHomePage(@PathVariable(name = "type") int type) {
		String mv = null;
		if (type == 1) {
			mv = "redirect:/enterOrder";
		}
		else if (type == 2) {
			mv = "redirect:/firstTimeDeliveryHomePage";
		}
		else if (type == 3) {
			mv = "redirect:/showReportType";
		}
		else if (type == 4) {
			mv = "redirect:/findOrder";
		}

		return mv;

	}

}
