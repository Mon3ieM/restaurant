package com.restaurant.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.restaurant.model.eo.FoodPrices;

public interface FoodPriceRepository extends JpaRepository<FoodPrices, Long>{

	@Query("select p from FoodPrices p where p.foodMenuId = :foodMenuId and p.foodSizeId = :foodSizeId")
	public FoodPrices getPriceForSelectedMenuItemPerSize(@Param("foodMenuId") Long foodMenuId, @Param("foodSizeId") Long foodSizeId);
	
}
