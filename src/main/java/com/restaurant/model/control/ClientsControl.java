package com.restaurant.model.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.restaurant.model.eo.Clients;
import com.restaurant.model.services.ClientsService;

@Controller
public class ClientsControl {

	@Autowired
	ClientsService clientServ;

	public Clients NewCL = new Clients();
	public Clients cl = new Clients();
	public String msg = "";

	@RequestMapping("/showClients")
	public ModelAndView DeliveryHomePage() {
		ModelAndView mv = new ModelAndView("Clients");
		mv.addObject("NewCL", NewCL);
		mv.addObject("cl", cl);
		mv.addObject("msg", msg);

		return mv;

	}

	@RequestMapping(value = "/findClientByMobile", method = RequestMethod.POST)
	public String GetClientBYMobile(@ModelAttribute("cl") Clients client) {
		List<Clients> findClients = clientServ.findbyMobile1(client.getMobile1());

		if (!findClients.isEmpty()) {
			Clients result = findClients.get(0);
			cl = result;
			msg = "";
		} else {
			cl = new Clients();
			msg = "العميل غير موجود";
		}

		return "redirect:/showClients";
	}

	@RequestMapping(value = "/AddNewClient", method = RequestMethod.POST)
	public String AddNewClient(@ModelAttribute("NewCL") Clients newClient) {

		List<Clients> findClients = clientServ.findbyMobile1(newClient.getMobile1());

		if (!findClients.isEmpty()) {
			Clients result = findClients.get(0);
			cl = result;
			msg = "رقم الموبيل موجود بالفعل";

		} else {

			clientServ.save(newClient);
			cl = newClient;
			NewCL = new Clients();
			msg = "تم الاضافه بنجاح ";
		}
		return "redirect:/showClients";
	}

	@RequestMapping(value = "/UpdateClient", method = RequestMethod.POST)
	public String UpdateClient(@ModelAttribute("cl") Clients ModifyClient) {

		clientServ.save(ModifyClient);

		cl = ModifyClient;

		msg = "تم التعديل بنجاح ";

		return "redirect:/showClients";
	}

}
