package com.restaurant.model.eo;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



/**
 * To create ID generator sequence "FOOD_SIZE_ID_SEQ_GEN":
 * CREATE SEQUENCE "FOOD_SIZE_ID_SEQ_GEN" INCREMENT BY 50 START WITH 50;
 */
@Entity
@Getter @Setter @NoArgsConstructor
@Table(name = "FOOD_SIZE")
public class FoodSize {
    @Id
    @Column(nullable = false)
    private BigDecimal id;
    private String name;
    @Column(name = "IS_ACTIVE")
    private BigDecimal isActive;


    
}
