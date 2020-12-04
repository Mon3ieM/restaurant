package com.restaurant.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.restaurant.model.eo.FoodMenu;
import com.restaurant.model.eo.Users;

@Repository
public interface FoodMenuRepository extends JpaRepository<FoodMenu, Long> {

}
