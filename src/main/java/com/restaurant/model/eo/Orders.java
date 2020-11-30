package com.restaurant.model.eo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Orders {

	@Column(name = "CLIENT_ID")
    private Long clientId;
    @Column(name = "DISCOUNT_ID")
    private Long discountId;
    @Id
    @Column(nullable = false)
    private Long id;
    @Column(name = "IS_ACTIVE")
    private Long isActive;
    @Column(name = "USER_ID")
    private Long userId;

   
}
