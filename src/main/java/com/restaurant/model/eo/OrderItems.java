package com.restaurant.model.eo;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor
@Table(name = "ORDER_ITEMS")
public class OrderItems {
	
	@ManyToOne(targetEntity = Orders.class)
	@JoinColumn(name="ORDER_ID")
	private Orders orderId;
	
    @Column(name = "FOOD_MENU_ID")
    private Long foodMenuId;
    @Id
    @Column(nullable = false)
    private Long id;
    @Column(name = "IS_ACTIVE")
    private Long isActive;
   
    @Column(name = "ORDER_ITEMS_COMMENT")
    private String orderItemsComment;
    private Long quantity;

   
}
