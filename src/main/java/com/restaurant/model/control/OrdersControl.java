package com.restaurant.model.control;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonParser;
import com.google.gson.Gson;
import com.restaurant.model.dto.FoodCategoryWithMenuDTO;
import com.restaurant.model.eo.Clients;
import com.restaurant.model.eo.FoodCategory;
import com.restaurant.model.eo.FoodMenu;
import com.restaurant.model.eo.OrderItems;
import com.restaurant.model.services.FoodCategoryService;
import com.restaurant.model.services.FoodMenuService;
import com.restaurant.model.services.OrdersService;

@Controller
public class OrdersControl {

	@Autowired
	private OrdersService serv;
	
	@Autowired
	private FoodCategoryService foodCategoryService;
	
	@Autowired
	private FoodMenuService foodMenuService;
	
	public List<FoodCategoryWithMenuDTO> foodCategoryList = new ArrayList<>();
	public List<FoodMenu> foodMenuList = new ArrayList<>();
	public OrderItems orderItemData = new OrderItems();
	public Integer test = 1;
	
	public List<OrderItems> orderItemsList  = new ArrayList<>();
	
	@RequestMapping("/showOrder")
	public ModelAndView viewOrderPage() {
		foodCategoryList =  foodCategoryService.listAllCategoryWithMenu();
		
		ModelAndView mv = new ModelAndView("OrderPage");
	    mv.addObject("listCategory", foodCategoryList);
	    mv.addObject("newOrderItem", orderItemData);
	    return mv;
	}
	
	@ResponseBody
	@GetMapping("/getMenuByCategoryId/{catId}")
	public String showFoodItemPerCategory(@PathVariable(name = "catId") long catId) {
		test = test + 1 ;
		System.out.println("test >> " + test);
		
		foodMenuList = foodMenuService.listAllByCategoryId(catId);
	    Gson gSon = new Gson();
	    return gSon.toJson(foodMenuService.listAllByCategoryId(catId));
	}
	
	@RequestMapping(value = "/AddNewOrderItem", method = RequestMethod.POST)
	public String AddNewClient(@ModelAttribute("orderItem") Clients newOrderItem) {

		
		return "redirect:/showOrder";
	}

	
	
	
	
	

}
