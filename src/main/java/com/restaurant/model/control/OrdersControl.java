package com.restaurant.model.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.restaurant.model.eo.FoodCategory;
import com.restaurant.model.eo.FoodMenu;
import com.restaurant.model.eo.OrderItems;
import com.restaurant.model.eo.Orders;
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
	
	@RequestMapping("/OrderCat")
	public String loadCategory(Model model) {
	    List<FoodCategory> foodCategory = foodCategoryService.listAll();
	    model.addAttribute("categ", foodCategory);
	    return "MenuItemsPage";
	}
	
	@RequestMapping("/OrderItem/{orderId}")
	public ModelAndView loadOrderItem(@PathVariable(name = "orderId") long orderId) {
		ModelAndView mv = new ModelAndView("OrderItemPage");
		FoodMenu fm = foodMenuService.get(orderId);
		OrderItems orderItem = new OrderItems(); 
	
		orderItem.setQuantity(1L);
		
		
		mv.addObject("fmenu", fm);
		mv.addObject("orItem", orderItem);
	    
	    
	    return mv;
	}
	
	

}
