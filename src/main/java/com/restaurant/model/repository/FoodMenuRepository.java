
package com.restaurant.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restaurant.model.eo.FoodMenu;

public interface FoodMenuRepository extends JpaRepository<FoodMenu, Long> {

	
}

