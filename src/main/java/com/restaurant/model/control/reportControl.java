package com.restaurant.model.control;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.reports.report;
import com.restaurant.model.eo.Users;

@Controller
public class reportControl {

	static List<report> reptype = null;
	static List<Users> user = null;
	static List<Users> results = new ArrayList<Users>();

	static {
		user = new ArrayList<>();
		reptype = new ArrayList<>();
		Users u = new Users();
		u.setFullName("Mostafa");
		u.setId(1L);
		u.setIsActive(1L);
		u.setPassword("123");
		u.setUserName("Mostafa");
		u.setRoleId(1L);
		user.add(u);
		Users u1 = new Users();
		u1.setFullName("Mahmoud");
		u1.setId(2L);
		u1.setIsActive(1L);
		u1.setPassword("123");
		u1.setUserName("Mahmoud");
		u1.setRoleId(2L);
		user.add(u1);

		reptype.add(new report("1", "Mostafa"));
		reptype.add(new report("2", "Talia"));
		reptype.add(new report("3", "Mayada"));
		reptype.add(new report("4", "Mon3em"));
		reptype.add(new report("5", "Mahmoud"));
	}

	@RequestMapping("/showReportType")
	public ModelAndView ReportType() {
		ModelAndView mv = new ModelAndView("ReportsTypes");
		return mv;

	}

	@RequestMapping("/ReportPageFilter/{type}")
	public String ReportHomePage(@PathVariable(name = "type") int type) {
		String mv = null;
		if (type == 1) {
			mv = "redirect:/showDelivery";
		} else if (type == 2) {
			mv = "redirect:/showCasher";
		} else if (type == 3) {
			mv = "redirect:/showGenerl";
		}
		return mv;
	}

	@GetMapping("/showDelivery")
	public ModelAndView showDelivery() {
		List<Users> deliveryUsers = new ArrayList<>();
		for (Users users : user) {
			if (users.getRoleId() == 1)
				deliveryUsers.add(users);
		}
		ModelAndView mv = new ModelAndView("ReportsDelivery");
		mv.addObject("delivery", deliveryUsers);
		mv.addObject("reportResult", results);
		return mv;
	}

	@GetMapping("/showCasher")
	public ModelAndView showCasher() {
		List<Users> casherUsers = new ArrayList<>();
		for (Users users : user) {
			if (users.getRoleId() == 1)
				casherUsers.add(users);
		}
		ModelAndView mv = new ModelAndView("ReportsCasher");
		mv.addObject("casher", casherUsers);
		mv.addObject("reportResult", results);
		return mv;
	}

	@GetMapping("/showGenerl")
	public ModelAndView showGenerl() {
		List<Users> generlUsers = new ArrayList<>();
		generlUsers = user;
		ModelAndView mv = new ModelAndView("Reports");
		mv.addObject("delivery", generlUsers);
		mv.addObject("reportResult", results);
		return mv;
	}

	@PostMapping(value = "/searchReportDelivery")
	public String findReportDelivery(@ModelAttribute("report") report rep) {
		System.err.print(rep.getDeliveryName() + "!!!!!!!!!!!!!!!");
		if (rep.getDeliveryName().equals("Mostafa")) {
			System.err.print(rep.getDeliveryName() + "!!!!!!!!!!!!!!!");
			Users u1 = new Users();
			u1.setFullName("Mahmoud");
			u1.setId(2L);
			u1.setIsActive(1L);
			u1.setPassword("123");
			u1.setUserName("Mahmoud");
			u1.setRoleId(2L);
			results.add(u1);
		}
		return "redirect:/showDelivery";

	}
	
	@PostMapping(value = "/searchReportCasher")
	public String findReportCasher(@ModelAttribute("report") report rep) {
		System.err.print(rep.getCasherName() + "!!!!!!!!!!!!!!!");
		if (rep.getCasherName().equals("Mostafa")) {
			System.err.print(rep.getCasherName() + "!!!!!!!!!!!!!!!");
			Users u1 = new Users();
			u1.setFullName("Mahmoud");
			u1.setId(2L);
			u1.setIsActive(1L);
			u1.setPassword("123");
			u1.setUserName("Mahmoud");
			u1.setRoleId(2L);
			results.add(u1);
		}
		return "redirect:/showCasher";

	}
	
	@PostMapping(value = "/searchReportGenerl")
	public String findReportGenerl(@ModelAttribute("report") report rep) {
		
		return "redirect:/showGenerl";

	}

}
