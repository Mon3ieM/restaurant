package com.restaurant.model.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.restaurant.model.eo.Clients;
import com.restaurant.model.services.ClientsService;
import com.restaurant.utils.SessionData;

@Controller
public class ClientsControl {

	@Autowired
	ClientsService clientServ;

	@Autowired
	SessionData sessionData;

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

	@RequestMapping("/firstTimeDeliveryHomePage")
	public ModelAndView firstTimeDeliveryHomePage() {
		ModelAndView mv = new ModelAndView("Clients");
		mv.addObject("NewCL", new Clients());
		mv.addObject("cl", new Clients());
		mv.addObject("msg", "");

		return mv;

	}

	@GetMapping(value = "/continueWithOrder")
	public String continueWithOrder() {
		if (cl == null || cl.getId() == null) {
			msg = "لم يتم اختيار العميل";
			return "redirect:/showClients";
		}
		sessionData.setClientInOrder(cl);
		return "redirect:/enterOrder";
	}

	@RequestMapping(value = "/findClientByMobile", method = RequestMethod.POST)
	public String GetClientBYMobile(@ModelAttribute("cl") Clients client) {
		if (client.getMobile1() != null) {
			List<Clients> findClients = clientServ.findbyMobile1(client.getMobile1());

			if (!findClients.isEmpty()) {
				Clients result = findClients.get(0);
				cl = result;
				msg = "";
			} else {
				cl = new Clients();
				msg = "العميل غير موجود";
			}
		} else {
			msg = "العميل غير موجود";
		}
		return "redirect:/showClients";
	}

	@RequestMapping(value = "/AddNewClient", method = RequestMethod.POST)
	public String AddNewClient(@ModelAttribute("NewCL") Clients newClient) {

		if (newClient.getName() != null && newClient.getMobile1() != null && newClient.getAddress() != null
				&& !newClient.getName().isBlank() && !newClient.getMobile1().isBlank()
				&& !newClient.getAddress().isBlank()) {
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
		} else {
			msg = "برجاء استكمال البيانات";
		}
		return "redirect:/showClients";
	}

	@RequestMapping(value = "/UpdateClient", method = RequestMethod.POST)
	public String UpdateClient(@ModelAttribute("cl") Clients ModifyClient) {
		if (ModifyClient.getName() != null && ModifyClient.getMobile1() != null && ModifyClient.getAddress() != null
				&& !ModifyClient.getName().isBlank() && !ModifyClient.getMobile1().isBlank()
				&& !ModifyClient.getAddress().isBlank()) {
			clientServ.save(ModifyClient);

			cl = ModifyClient;

			msg = "تم التعديل بنجاح ";
		} else {
			msg = "برجاء استكمال البيانات";
		}
		return "redirect:/showClients";
	}

}
