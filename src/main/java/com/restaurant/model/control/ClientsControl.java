package com.restaurant.model.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.restaurant.model.eo.Clients;
import com.restaurant.model.services.ClientsService;

@Controller
public class ClientsControl {

	@Autowired
	ClientsService clientServ;

	@RequestMapping(value = "/findClientByMobile", method = RequestMethod.POST)
	public ModelAndView GetClientBYMobile(@ModelAttribute("cl") Clients client) {
		ModelAndView mv;
		System.out.print(client.getMobile1() + "t99999999999999999999");
		List<Clients> findClients = clientServ.findbyMobile1(client.getMobile1());

		if (!findClients.isEmpty()) {
			mv = new ModelAndView("Clients");
			Clients result = findClients.get(0);
			mv.addObject("cl", result);
			mv.addObject("msg", "");
		} else {
			mv = new ModelAndView("Clients");
			mv.addObject("cl", new Clients());
			mv.addObject("msg", "العميل غير موجود");
		}
		mv.addObject("NewCL", new Clients());

		return mv;
	}

	@RequestMapping(value = "/AddNewClient", method = RequestMethod.POST)
	public ModelAndView AddNewClient(@ModelAttribute("NewCL") Clients newClient) {
		ModelAndView mv;

		System.out.print(newClient.getMobile1() + "t99999999999999999999");
		List<Clients> findClients = clientServ.findbyMobile1(newClient.getMobile1());

		if (!findClients.isEmpty()) {
			mv = new ModelAndView("Clients");
			Clients result = findClients.get(0);
			mv.addObject("cl", result);
			mv.addObject("msg", "رقم الموبيل موجود بالفعل");
		} else {
			newClient.setId(2L);
			clientServ.save(newClient);
			mv = new ModelAndView("Clients");
			mv.addObject("cl", newClient);
			mv.addObject("NewCL", new Clients());
			mv.addObject("msg", "تم الاضافه بنجاح ");
		}
		return mv;
	}

	@RequestMapping(value = "/UpdateClient", method = RequestMethod.POST)
	public ModelAndView UpdateClient(@ModelAttribute("cl") Clients ModifyClient) {
		ModelAndView mv;

		System.out.print(ModifyClient.getId() + "t99999999999999999999");
		clientServ.save(ModifyClient);
		mv = new ModelAndView("Clients");
		mv.addObject("cl", ModifyClient);
		mv.addObject("NewCL", new Clients());
		mv.addObject("msg", "تم التعديل بنجاح ");
		return mv;
	}

}
