package com.restaurant.model.eo;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor
public class Store {
    @Id
    @Column(nullable = false)
    private BigDecimal id;
    @Column(name = "INGRADIENT_ID")
    private BigDecimal ingradientId;
    @Column(name = "IS_ACTIVE")
    private BigDecimal isActive;
    @Column(name = "TRANSACTION_TYPE", length = 20)
    private String transactionType;

   
}
