package com.restaurant.model.dto;

import java.util.ArrayList;
import java.util.List;



import com.restaurant.model.eo.FoodMenu;

public class FoodCategoryWithMenuDTO {

	private Long id;

	private String name;
	
	private List<FoodMenu> foodMenuList = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<FoodMenu> getFoodMenuList() {
		return foodMenuList;
	}

	public void setFoodMenuList(List<FoodMenu> foodMenuList) {
		this.foodMenuList = foodMenuList;
	}

}
