package com.restaurant.model.dto;


public class OrderItemDTO {

	private Long orderId;

	private Long price;

	private Long id;
	private String orderItemsComment;
	private Long quantity;
	
	
	
	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	public Long getPrice() {
		return price;
	}
	public void setPrice(Long price) {
		this.price = price;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getOrderItemsComment() {
		return orderItemsComment;
	}
	public void setOrderItemsComment(String orderItemsComment) {
		this.orderItemsComment = orderItemsComment;
	}
	public Long getQuantity() {
		return quantity;
	}
	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

}
