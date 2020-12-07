package com.restaurant.model.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.restaurant.model.eo.FoodCategory;
import com.restaurant.model.eo.FoodMenu;
import com.restaurant.model.eo.OrderItems;
import com.restaurant.model.services.FoodCategoryService;
import com.restaurant.model.services.FoodMenuService;
import com.restaurant.model.services.OrdersService;

@Controller
@RequestMapping("/Order")
public class OrdersControl {

	@Autowired
	private OrdersService serv;
	
	@Autowired
	private FoodCategoryService foodCategoryService;
	
	@Autowired
	private FoodMenuService foodMenuService;
	
	@GetMapping("/")
	public String viewHomePage(Model model) {
	    List<FoodCategory> foodCategory = foodCategoryService.listAll();
	    model.addAttribute("listCategory", foodCategory);
	    return "OrderPage";
	}
	
	@RequestMapping("/Order")
	public String loadCategory(Model model) {
	    List<FoodCategory> foodCategory = foodCategoryService.listAll();
	    model.addAttribute("categ", foodCategory);
	    return "OrderPage";
	}
	
	@GetMapping(path = "/OrderItem/{orderId}")
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
