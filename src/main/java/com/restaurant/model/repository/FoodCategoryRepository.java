package com.restaurant.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restaurant.model.eo.FoodCategory;

public interface FoodCategoryRepository extends JpaRepository<FoodCategory, Long> {

}
