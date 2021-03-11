package com.restaurant.model.control;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.restaurant.model.dto.ReportDTO;
import com.restaurant.model.dto.ReportMenuDataQtyDTO;
import com.restaurant.model.eo.Orders;
import com.restaurant.model.eo.Users;
import com.restaurant.model.services.OrdersService;
import com.restaurant.model.services.UsersService;
import com.restaurant.utils.JavaUtils;

@Controller
public class ReportControl {

	static List<ReportDTO> reptype = null;
	static List<Users> user = null;
	static List<Users> results = new ArrayList<Users>();
	public List<Users> delivery = new ArrayList<Users>();
	public List<Users> Casher = new ArrayList<Users>();
	public List<Orders> OrdersDelivery = new ArrayList<Orders>();
	public List<Orders> OrdersCasher = new ArrayList<Orders>();
	public List<Orders> Orders = new ArrayList<Orders>();
	public List<ReportMenuDataQtyDTO> ReportMenuDataQty = new ArrayList<ReportMenuDataQtyDTO>();



	Long totalPerCasherOrders = 0L;
	Long totalPerDeliveryOrders = 0L;

	@Autowired
	private UsersService userserv;
	@Autowired
	private OrdersService oServece;

	

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
		} else if (type == 4) {
			mv = "redirect:/showDailyReport";
		}
		return mv;
	}

	@GetMapping("/showDelivery")
	public ModelAndView showDelivery() {
		delivery = userserv.findByRoleId(3L);

		ModelAndView mv = new ModelAndView("ReportsDelivery");
		mv.addObject("delivery", delivery);
		mv.addObject("total", totalPerDeliveryOrders);
		mv.addObject("reportResult", OrdersDelivery);
		return mv;
	}

	@GetMapping("/showCasher")
	public ModelAndView showCasher() {
		Casher = userserv.findByRoleId(1L);
		ModelAndView mv = new ModelAndView("ReportsCasher");
		mv.addObject("casher", Casher);
		mv.addObject("total", totalPerCasherOrders);
		mv.addObject("reportResult", OrdersCasher);
		return mv;
	}

	@GetMapping("/showDailyReport")
	public ModelAndView showDailyReport() {
		ModelAndView mv = new ModelAndView("DailyReports");

		ReportDTO rep = new ReportDTO();
		Long total = oServece.getAllAmount();
		rep.setTo(JavaUtils.getTomorrowAsString());
		rep.setFrom(JavaUtils.getTodayAsString());
		rep.setTotalAmount(total == null ? 0L : total);
		mv.addObject("reportResult", rep);

		return mv;
	}

	@GetMapping("/showGenerl")
	public ModelAndView showGenerl() {
		ModelAndView mv = new ModelAndView("Reports");
		mv.addObject("reportResult", ReportMenuDataQty);	
		return mv;
	}
	@GetMapping("/SearchGenerl")
	public ModelAndView showGenerl(@ModelAttribute("report") ReportDTO rep) throws ParseException {
		System.err.print(rep.getFrom() + "!!!!!!!!!!!!!!!");
		System.err.print(rep.getTo() + "!!!!!!!!!!!!!!!");
		
		ModelAndView mv = new ModelAndView("Reports");
		return mv;
	}

	@PostMapping(value = "/searchReportDelivery")
	public String findReportDelivery(@ModelAttribute("report") ReportDTO rep) throws ParseException {
		System.err.print(rep.getDeliveryName() + "!!!!!!!!!!!!!!!");
		System.err.print(rep.getFrom() + "!!!!!!!!!!!!!!!");
		System.err.print(rep.getTo() + "!!!!!!!!!!!!!!!");
		if (rep.getDeliveryName() !=null && rep.getFrom() !=null &&rep.getTo() != null) {
			OrdersDelivery=oServece.getOrdersFromToByDeliveryID(rep.getFrom(), rep.getTo(), rep.getDeliveryName());	
			for (Orders or : OrdersDelivery) {
				totalPerDeliveryOrders+=or.getTotalPrice();
			}
		}
		return "redirect:/showDelivery";

	}

	@PostMapping(value = "/searchReportCasher")
	public String findReportCasher(@ModelAttribute("report") ReportDTO rep) throws ParseException {
		System.err.print(rep.getCasherName()+ "!!!!!!!!!!!!!!!");
		System.err.print(rep.getFrom() + "!!!!!!!!!!!!!!!");
		System.err.print(rep.getTo() + "!!!!!!!!!!!!!!!");
		if (rep.getCasherName() !=null && rep.getFrom() !=null &&rep.getTo() != null) {
			OrdersCasher=oServece.getOrdersFromToByCasherID(rep.getFrom(), rep.getTo(), rep.getCasherName());	
			for (Orders or : OrdersCasher) {
				totalPerCasherOrders+=or.getTotalPrice();
			}
		}
		return "redirect:/showCasher";

	}

	@PostMapping(value = "/SearchGenerl")
	public String SearchGenerl(@ModelAttribute("report") ReportDTO rep) throws ParseException {
		System.err.print(JavaUtils.getDateFromString(rep.getFrom()) + "!!!!!!!!!!!!!!!");
		System.err.print(JavaUtils.getDateFromString(rep.getTo()) + "!!!!!!!!!!!!!!!");
		if (rep.getFrom() !=null &&rep.getTo() != null) {
			ReportMenuDataQty=oServece.getMenuQtyReportDate(JavaUtils.getDateFromString(rep.getFrom()),JavaUtils.getDateFromString(rep.getTo()));
			System.err.print(Orders + "!!!!!!!!!!!!!!!");
		}
		return "redirect:/showGenerl";

	}
	@PostMapping(value = "/searchReportGenerl")
	public String findReportGenerl(@ModelAttribute("report") ReportDTO rep) {

		return "redirect:/showGenerl";

	}

}
