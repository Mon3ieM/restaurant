package com.restaurant.model.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.restaurant.model.eo.Orders;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Long> {

	

}
