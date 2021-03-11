
package com.restaurant.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restaurant.model.eo.FoodMenu;

public interface FoodMenuRepository extends JpaRepository<FoodMenu, Long> {
	
	List<FoodMenu> findByFoodCategoryId(Long foodCategoryId);
	
}

