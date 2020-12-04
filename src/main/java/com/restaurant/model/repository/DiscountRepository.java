package com.restaurant.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restaurant.model.eo.Discount;

public interface DiscountRepository extends JpaRepository<Discount, Long> {

}
