package com.restaurant.model.eo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

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

    @OneToMany(mappedBy = "orderId" , cascade = CascadeType.ALL)
    List<OrderItems> orderItemsList = new ArrayList<>();
   
}
