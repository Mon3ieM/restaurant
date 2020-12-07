package com.restaurant.model.eo;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "ORDER_ITEMS")
@SequenceGenerator(name = "OrderItems_Seq_Gen", sequenceName = "ORDER_ITEMS_SEQ",
allocationSize = 1, initialValue = 1)

public class OrderItems {
	
	@Column(name="ORDER_ID")
	private Long orderId;
	
    @Column(name = "FOOD_PRICE_ID")
    private Long foodPriceId;
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "OrderItems_Seq_Gen")
    private Long id;

    @Column(name = "ORDER_ITEMS_COMMENT")
    private String orderItemsComment;
    private Long quantity;
    
    
	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
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
