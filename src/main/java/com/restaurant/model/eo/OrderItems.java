package com.restaurant.model.eo;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
	
//	@Column(name="ORDER_ID")
//	private Long orderId;
	
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false , cascade = CascadeType.PERSIST )
	@JoinColumn(name = "ORDER_ID")
	private Orders order;

	@Column(name = "FOOD_PRICE_ID")
    private Long foodPriceId;
<<<<<<< HEAD
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "FOOD_PRICE_ID" , insertable = false , updatable = false)
	private FoodPrices foodPriceEO;
	
    public FoodPrices getFoodPriceEO() {
		return foodPriceEO;
	}
	public void setFoodPriceEO(FoodPrices foodPriceEO) {
		this.foodPriceEO = foodPriceEO;
	}
	@Id
=======
    @Id
>>>>>>> 95427e7b70ec812f9d113fa19c90a374f0daabc9
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "OrderItems_Seq_Gen")
    private Long id;

    @Column(name = "ORDER_ITEMS_COMMENT")
    private String orderItemsComment;
    private Long quantity;
    
    
	
    public Orders getOrder() {
		return order;
	}
	public void setOrder(Orders order) {
		this.order = order;
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
