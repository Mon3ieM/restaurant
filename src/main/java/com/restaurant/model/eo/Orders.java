package com.restaurant.model.eo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import lombok.Getter;
import lombok.Setter;

@Entity
@SequenceGenerator(name = "Orders_Seq_Gen", sequenceName = "ORDERS_SEQ",
allocationSize = 1, initialValue = 1)
public class Orders {

	@Column(name = "CLIENT_ID")
    private Long clientId;
    @Column(name = "DISCOUNT_ID")
    private Long discountId;
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Orders_Seq_Gen")
    private Long id;
    @Column(name = "IS_ACTIVE")
    private Long isActive;
    @Column(name = "USER_ID")
    private Long userId;
    
    @Column(name = "DELIVERY_ID")
    private Long deliveryId;
    
    
    @OneToMany(mappedBy = "order" , cascade = CascadeType.ALL , orphanRemoval = true)
    List<OrderItems> orderItemsList ;
    @Column(name = "TOTAL_PRICE")
    private Long totalPrice;
    
    
	public Long getDeliveryId() {
		return deliveryId;
	}
	public void setDeliveryId(Long deliveryId) {
		this.deliveryId = deliveryId;
	}
	public Long getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(Long totalPrice) {
		this.totalPrice = totalPrice;
	}
	public Long getClientId() {
		return clientId;
	}
	public void setClientId(Long clientId) {
		this.clientId = clientId;
	}
	public Long getDiscountId() {
		return discountId;
	}
	public void setDiscountId(Long discountId) {
		this.discountId = discountId;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getIsActive() {
		return isActive;
	}
	public void setIsActive(Long isActive) {
		this.isActive = isActive;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public List<OrderItems> getOrderItemsList() {
		return orderItemsList;
	}
	public void setOrderItemsList(List<OrderItems> orderItemsList) {
		this.orderItemsList = orderItemsList;
	}

   
}
