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
@Table(name = "FOOD_MENU")
public class FoodMenu {
   
    @Column(name = "FOOD_CATEGORY_ID")
    private BigDecimal foodCategoryId;
    @Column(name = "FOOD_SIZE_ID")
    private BigDecimal foodSizeId;
    
    @Id
    @Column(nullable = false)
    private BigDecimal id;
    @Column(name = "IS_ACTIVE")
    private BigDecimal isActive;
    private String name;
    private BigDecimal price;




}
