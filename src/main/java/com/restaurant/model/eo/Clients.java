package com.restaurant.model.eo;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;


@Entity
@Data
public class Clients {
    private String address;
    @Column(name = "BLOCKED_REASON")
    private String blockedReason;
    @Column(nullable = false)
    @Id
    private Long id;
    @Column(name = "IS_ACTIVE")
    private Long isActive;
    @Column(name = "IS_BLOCKED")
    private Long isBlocked;
    @Column(length = 20)
    private String mobile1;
    @Column(length = 20)
    private String mobile2;
    private String name;
    private String notes;

   
}
