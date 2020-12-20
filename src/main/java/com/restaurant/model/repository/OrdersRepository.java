package com.restaurant.model.repository;



import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.restaurant.model.eo.Orders;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Long> {
	@Query("select o from Orders o where o.id = :orderId and  o.clientId is not null")
	 public Orders getDeliveryOrders(@Param("orderId") Long orderId);
	
	@Query("select sum(o.totalPrice) from Orders o where o.creationDate = :cdate")
	 public long getTotalAmount(@Param("cdate") Date cdate);


}
