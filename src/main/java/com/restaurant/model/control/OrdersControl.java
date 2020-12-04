package com.restaurant.model.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.restaurant.model.eo.FoodCategory;
import com.restaurant.model.eo.Orders;
import com.restaurant.model.services.FoodCategoryService;
import com.restaurant.model.services.OrdersService;

@Controller
public class OrdersControl {

	@Autowired
	private OrdersService serv;
	
	@Autowired
	private FoodCategoryService foodCategoryService;
	
	@RequestMapping("/OrderCat")
	public String viewHomePage(Model model) {
		System.out.println("TEST .............. ");
	    List<FoodCategory> foodCategory = foodCategoryService.listAll();
	    model.addAttribute("categ", foodCategory);
	    model.addAttribute("categCount", foodCategory.size());
	    return "MenuItemsPage";
	}
	
}
