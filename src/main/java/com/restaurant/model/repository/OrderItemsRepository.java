package com.restaurant.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restaurant.model.eo.OrderItems;

public interface OrderItemsRepository extends JpaRepository<OrderItems, Long> {

}
