package com.restaurant.model.dto;

public class FoodItemDataDTO {
private Long id;
private String foodMenuName;
private String size;
private Long qty;
private String comment;
private Long foodMenuId;
private Long foodSizeId;
private Long price;
private Long foodPriceId;



public Long getFoodPriceId() {
	return foodPriceId;
}
public void setFoodPriceId(Long foodPriceId) {
	this.foodPriceId = foodPriceId;
}
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public Long getFoodSizeId() {
	return foodSizeId;
}
public void setFoodSizeId(Long foodSizeId) {
	this.foodSizeId = foodSizeId;
}
public Long getPrice() {
	return price;
}
public void setPrice(Long price) {
	this.price = price;
}
public String getFoodMenuName() {
	return foodMenuName;
}
public void setFoodMenuName(String foodMenuName) {
	this.foodMenuName = foodMenuName;
}
public String getSize() {
	return size;
}
public void setSize(String size) {
	this.size = size;
}
public Long getQty() {
	return qty;
}
public void setQty(Long qty) {
	this.qty = qty;
}
public String getComment() {
	return comment;
}
public void setComment(String comment) {
	this.comment = comment;
}
public Long getFoodMenuId() {
	return foodMenuId;
}
public void setFoodMenuId(Long foodMenuId) {
	this.foodMenuId = foodMenuId;
}


}
