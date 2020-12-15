package com.restaurant.model.control;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.restaurant.model.dto.CheuqeDTO;
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
import com.restaurant.utils.PrintCheque;
import com.restaurant.utils.SessionData;

@Controller
public class OrdersControl {
	private final String errorMsg_WrongSize = "الحجم غير متاح ";
	private final String success_Mssg = "تمت العملية بنجاح";

	@Autowired
	private SessionData sessionData;

	@Autowired
	private OrdersService serv;

	@Autowired
	private FoodCategoryService foodCategoryService;

	@Autowired
	private FoodMenuService foodMenuService;

	public Map<Long, List<FoodMenu>> menuData = new HashMap<>();
	public List<FoodCategoryWithMenuDTO> foodCategoryList = new ArrayList<>();
	public List<FoodMenu> foodMenuList = new ArrayList<>();
	public OrderItems orderItemData = new OrderItems();
	public Long orderItemCount = 0L;
	public Long totalPrice = 0L;
	public String msg = "";
	public Clients clientInOrder = new Clients();

	public List<FoodItemDataDTO> foodItemOrderList = new ArrayList<>();

	private void preparData(List<FoodCategoryWithMenuDTO> foodCategoryList) {
		for (FoodCategoryWithMenuDTO d : foodCategoryList) {
			menuData.put(d.getId(), d.getFoodMenuList());
		}
	}

	@RequestMapping("/enterOrder")
	public ModelAndView enterOrder() {
		clearData();
		foodCategoryList = foodCategoryService.listAllCategoryWithMenu();
		preparData(foodCategoryList);
		Clients c = sessionData.getClientInOrder();
		if (c != null) {
			clientInOrder = c;
			sessionData.setClientInOrder(null);
		}

		ModelAndView mv = new ModelAndView("OrderPage");
		mv.addObject("listCategory", foodCategoryList);
		mv.addObject("foodMenuList", foodMenuList);
		mv.addObject("newOrderItem", orderItemData);
		mv.addObject("totalPrice", totalPrice);
		mv.addObject("foodItemOrderList", foodItemOrderList);
		mv.addObject("msg", msg);
		mv.addObject("clientData", clientInOrder);
		return mv;
	}

	@RequestMapping("/showOrder")
	public ModelAndView viewOrderPage() {
		if (foodCategoryList.isEmpty()) {
			foodCategoryList = foodCategoryService.listAllCategoryWithMenu();
			preparData(foodCategoryList);
		}
		ModelAndView mv = new ModelAndView("OrderPage");
		mv.addObject("listCategory", foodCategoryList);
		mv.addObject("foodMenuList", foodMenuList);
		mv.addObject("newOrderItem", orderItemData);
		mv.addObject("totalPrice", totalPrice);
		mv.addObject("msg", msg);
		mv.addObject("clientData", clientInOrder);
		mv.addObject("foodItemOrderList", foodItemOrderList);
		return mv;
	}

	@RequestMapping("/getMenuByCategoryId/{catId}")
	public String showFoodMenuPerCategory(@PathVariable(name = "catId") long catId) {
		foodMenuList = menuData.get(catId);
		return "redirect:/showOrder";
	}

	@GetMapping("/removeFoodItemOrder/{foodId}")
	public String removeFoodItemOrder(@PathVariable(name = "foodId") long foodId) {
		System.out.println(foodId);
		for (FoodItemDataDTO d : foodItemOrderList) {
			if (d.getId().equals(foodId)) {
				foodItemOrderList.remove(d);
				totalPrice = totalPrice - (d.getPrice() * d.getQty());
				break;
			}
		}

		return "redirect:/showOrder";
	}

	@ResponseBody
	@GetMapping("/getMenuPrice/{catId}")
	public String showFoodItemPerCategory1(@PathVariable(name = "catId") long catId) {
		foodMenuList = menuData.get(catId);
		Gson gSon = new Gson();
		return gSon.toJson(foodMenuService.listAllByCategoryId(catId));
	}

	@PostMapping(value = "/sendNeededDataAndGetPrice")
	public String addItemToOrder(@ModelAttribute("FoodItemDataDTO") FoodItemDataDTO fitemDTO) {
		FoodPrices priceObject = serv.getFoodPrice(fitemDTO.getFoodMenuId(), fitemDTO.getFoodSizeId());
		if (priceObject == null || priceObject.getPrice() == null) {
			msg = errorMsg_WrongSize;
		} else {
			orderItemCount += 1;
			fitemDTO.setId(orderItemCount);
			fitemDTO.setPrice(priceObject.getPrice());
			fitemDTO.setFoodPriceId(priceObject.getId());
			fitemDTO.setSize(getSizeName(fitemDTO.getFoodSizeId()));

			totalPrice += (priceObject.getPrice() * fitemDTO.getQty());
			foodItemOrderList.add(fitemDTO);
			msg = success_Mssg;
		}
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
		if (sessionData.getLoggedUser() != null)
			order.setUserId(sessionData.getLoggedUser().getId());
		if (clientInOrder != null && clientInOrder.getId() != null)
			order.setClientId(clientInOrder.getId());
		order.setTotalPrice(totalPrice);
		serv.createNewOrder(order);

		//preparCheuqeAndPrint(order);

		clearData();
		return "redirect:/showOrder";
	}

	private void preparCheuqeAndPrint(Orders order) {

		CheuqeDTO cheq = new CheuqeDTO();
		cheq.setOrder(order);

		cheq.setFoodItemData(foodItemOrderList);
		if (sessionData.getLoggedUser() != null)
			cheq.setUser(sessionData.getLoggedUser());
		if (clientInOrder != null && clientInOrder.getId() != null)
			cheq.setClient(clientInOrder);

		PrintCheque pc = new PrintCheque(cheq);
		pc.printAction();
	}

	private void clearData() {
		foodCategoryList = new ArrayList<>();
		foodMenuList = new ArrayList<>();
		orderItemData = new OrderItems();
		orderItemCount = 0L;
		totalPrice = 0L;
		foodItemOrderList = new ArrayList<>();
		clientInOrder = new Clients();
	}

}
