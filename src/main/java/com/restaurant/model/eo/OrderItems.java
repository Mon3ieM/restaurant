package com.restaurant.model.eo;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor
@Table(name = "ORDER_ITEMS")
public class OrderItems {
    @Column(name = "FOOD_MENU_ID")
    private BigDecimal foodMenuId;
    @Id
    @Column(nullable = false)
    private BigDecimal id;
    @Column(name = "IS_ACTIVE")
    private BigDecimal isActive;
    @Column(name = "ORDER_ID")
    private BigDecimal orderId;
    @Column(name = "ORDER_ITEMS_COMMENT")
    private String orderItemsComment;
    private BigDecimal quantity;

   
}
