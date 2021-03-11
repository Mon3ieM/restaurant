package com.restaurant.model.dto;

import java.util.ArrayList;
import java.util.List;

import com.restaurant.model.eo.Clients;
import com.restaurant.model.eo.Orders;
import com.restaurant.model.eo.Users;

public class CheuqeDTO {

	private Orders order = new Orders();
	private List<FoodItemDataDTO> foodItemData = new ArrayList<>();

	private Clients client = new Clients();

	private Users user = new Users();

	public Orders getOrder() {
		return order;
	}

	public void setOrder(Orders order) {
		this.order = order;
	}

	public List<FoodItemDataDTO> getFoodItemData() {
		return foodItemData;
	}

	public void setFoodItemData(List<FoodItemDataDTO> foodItemData) {
		this.foodItemData = foodItemData;
	}

	public Clients getClient() {
		return client;
	}

	public void setClient(Clients client) {
		this.client = client;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

}
