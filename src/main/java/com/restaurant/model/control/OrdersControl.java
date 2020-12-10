package com.restaurant.model.control;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonParser;
import com.google.gson.Gson;
import com.reports.report;
import com.restaurant.model.dto.FoodCategoryWithMenuDTO;
import com.restaurant.model.dto.FoodItemDataDTO;
import com.restaurant.model.eo.Clients;
import com.restaurant.model.eo.FoodCategory;
import com.restaurant.model.eo.FoodMenu;
import com.restaurant.model.eo.FoodPrices;
import com.restaurant.model.eo.OrderItems;
import com.restaurant.model.eo.Orders;
import com.restaurant.model.eo.Users;
import com.restaurant.model.services.FoodCategoryService;
import com.restaurant.model.services.FoodMenuService;
import com.restaurant.model.services.OrdersService;
import com.restaurant.utils.SessionData;


@Controller
public class OrdersControl {
	@Autowired
	private SessionData sessionData;
	
	@Autowired
	private OrdersService serv;

	@Autowired
	private FoodCategoryService foodCategoryService;

	@Autowired
	private FoodMenuService foodMenuService;

	public List<FoodCategoryWithMenuDTO> foodCategoryList = new ArrayList<>();
	public List<FoodMenu> foodMenuList = new ArrayList<>();
	public OrderItems orderItemData = new OrderItems();
	public Long orderItemCount = 0L;
	public Long totalPrice = 0L;

	public List<FoodItemDataDTO> foodItemOrderList = new ArrayList<>();

	@RequestMapping("/enterOrder")
	public ModelAndView enterOrder() {
		clearData();
		foodCategoryList = foodCategoryService.listAllCategoryWithMenu();

		ModelAndView mv = new ModelAndView("OrderPage");
		mv.addObject("listCategory", foodCategoryList);
		mv.addObject("foodMenuList", foodMenuList);
		mv.addObject("newOrderItem", orderItemData);
		mv.addObject("totalPrice", totalPrice);
		mv.addObject("foodItemOrderList", foodItemOrderList);
		return mv;
	}
	
	@RequestMapping("/showOrder")
	public ModelAndView viewOrderPage() {
		foodCategoryList = foodCategoryService.listAllCategoryWithMenu();

		ModelAndView mv = new ModelAndView("OrderPage");
		mv.addObject("listCategory", foodCategoryList);
		mv.addObject("foodMenuList", foodMenuList);
		mv.addObject("newOrderItem", orderItemData);
		mv.addObject("totalPrice", totalPrice);
		mv.addObject("foodItemOrderList", foodItemOrderList);
		return mv;
	}


	@RequestMapping("/getMenuByCategoryId/{catId}")
	public String showFoodMenuPerCategory(@PathVariable(name = "catId") long catId) {
		foodMenuList = foodMenuService.listAllByCategoryId(catId);
		return "redirect:/showOrder";
	}

	@GetMapping("/removeFoodItemOrder/{foodId}")
	public String removeFoodItemOrder(@PathVariable(name = "foodId") long foodId) {
		System.out.println(foodId);
		for (FoodItemDataDTO d : foodItemOrderList) {
			if (d.getId().equals(foodId)) {
				foodItemOrderList.remove(d);
				totalPrice = totalPrice - d.getPrice();
				break;
			}
		}

		return "redirect:/showOrder";
	}
	
	@ResponseBody
	@GetMapping("/getMenuPrice/{catId}")
	public String showFoodItemPerCategory1(@PathVariable(name = "catId") long catId) {
		foodMenuList = foodMenuService.listAllByCategoryId(catId);
	    Gson gSon = new Gson();
	    return gSon.toJson(foodMenuService.listAllByCategoryId(catId));
	}

	@PostMapping(value = "/sendNeededDataAndGetPrice")
	public String sendNeededDataAndGetPrice(@ModelAttribute("FoodItemDataDTO") FoodItemDataDTO fitemDTO) {
		orderItemCount += 1;
		FoodPrices priceObject = serv.getFoodPrice(fitemDTO.getFoodMenuId(), fitemDTO.getFoodSizeId());

		fitemDTO.setId(orderItemCount);
		fitemDTO.setPrice(priceObject.getPrice());
		fitemDTO.setFoodPriceId(priceObject.getId());
		fitemDTO.setSize(getSizeName(fitemDTO.getFoodSizeId()));

		totalPrice += priceObject.getPrice();
		foodItemOrderList.add(fitemDTO);

		return "redirect:/showOrder";

	}

	private String getSizeName(long id) {
		if (id == 1)
			return "S";
		else if (id == 2)
			return "M";
		else if (id == 3)
			return "L";
		else if (id == 4)
			return "Family";

		return "";
	}

	@GetMapping("/calculateFinalPrice")
	public String calculateFinalPrice() {
		Orders order = new Orders();
		List<OrderItems> detailItems = new ArrayList<>();
		for (FoodItemDataDTO fItem : foodItemOrderList) {
			OrderItems eo = new OrderItems();
			eo.setFoodPriceId(fItem.getFoodPriceId());
			eo.setOrderItemsComment(fItem.getComment());
			eo.setQuantity(fItem.getQty());
			eo.setOrder(order);
			detailItems.add(eo);
		}
		order.setOrderItemsList(detailItems);
		order.setUserId(sessionData.getLoggedUser().getId());

		serv.createNewOrder(order);

		clearData();
		return "redirect:/showOrder";
	}

	private void clearData() {
		foodCategoryList = new ArrayList<>();
		foodMenuList = new ArrayList<>();
		orderItemData = new OrderItems();
		orderItemCount = 0L;
		totalPrice = 0L;
		foodItemOrderList = new ArrayList<>();
	}

}
