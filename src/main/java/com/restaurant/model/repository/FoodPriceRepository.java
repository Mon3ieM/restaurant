package com.restaurant.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.restaurant.model.eo.FoodPrices;

public interface FoodPriceRepository extends JpaRepository<FoodPrices, Long>{


	
//	@Query("select p.price from FoodPrices p where p.foodMenuId = :foodMenuId and p.foodSizeId = :foodSizeId")
//	public Long getPriceForSelectedMenuItemPerSize(@Param("username") String username, @Param("password") String password);
}
