package com.restaurant.model.control;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

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
	
	public List<FoodCategory> foodCategoryList = new ArrayList<>();
	public List<FoodMenu> foodMenuList = new ArrayList<>();
	
	@RequestMapping("/showOrder")
	public ModelAndView viewOrderPage() {
		foodCategoryList =  foodCategoryService.listAll();
		
		ModelAndView mv = new ModelAndView("OrderPage");
	    mv.addObject("listCategory", foodCategoryList);
	    mv.addObject("foodMenuList", foodMenuList);
	    System.out.println( "...... foodMenu ---- " + foodMenuList.size());
	    return mv;
	}
	
	@RequestMapping("/getMenuByCategoryId/{catId}")
	public String showFoodItemPerCategory(@PathVariable(name = "catId") long catId) {
		
		foodMenuList = foodMenuService.listAllByCategoryId(catId);
		System.out.println(foodMenuList.size()+" ===.........");
	    
	    return "redirect:/showOrder";
	}
	
	
	
	
	

}
