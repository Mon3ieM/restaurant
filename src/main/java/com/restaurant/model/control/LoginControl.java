package com.restaurant.model.control;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.print.PrintException;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.lowagie.text.DocumentException;
import com.reports.PDFExporter;
import com.restaurant.model.eo.FoodMenu;
import com.restaurant.model.eo.OrderItems;
import com.restaurant.model.eo.Orders;
import com.restaurant.model.eo.Users;
import com.restaurant.model.services.OrdersService;
import com.restaurant.model.services.UsersService;
import com.restaurant.utils.SessionData;

@Controller
public class LoginControl {

	@Autowired
	private UsersService userServ;

	@Autowired
	private SessionData sessionData;

	@RequestMapping("/")
	public String viewHomePage(Model model) {
//		System.out.println("TEST .............. ");
		Users userDTO = new Users();
		model.addAttribute("user", userDTO);
		return "test";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String findUser(@ModelAttribute("user") Users user) {

		Users us = userServ.findByUsernameAndPassword(user.getUserName(), user.getPassword());

		if (us != null) {
			System.err.print(us.getId());
			sessionData.setLoggedUser(us);
			return "redirect:/HomePage";
		} else {
			System.err.println("--------------Not Found-----------------");
			return "redirect:/";
		}
	}
	
	@GetMapping("/pdf")
    public void exportToPDF(HttpServletResponse response) throws DocumentException, IOException {
        response.setContentType("application/pdf");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());
         
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=users_" + currentDateTime + ".pdf";
        response.setHeader(headerKey, headerValue);
         
         
        PDFExporter exporter = new PDFExporter();
        exporter.export(response);
         
    }
	@GetMapping("/print")
    public void print(HttpServletResponse response) throws DocumentException, IOException, com.itextpdf.text.DocumentException, PrintException {
		com.reports.print p =new com.reports.print();
		p.test();
         
         
    }

}
