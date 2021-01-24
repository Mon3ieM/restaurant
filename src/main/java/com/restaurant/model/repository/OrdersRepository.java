package com.restaurant.model.repository;



import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.restaurant.model.eo.Orders;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Long> {
	@Query("select o from Orders o where o.id = :orderId and  o.clientId is not null")
	 public Orders getDeliveryOrders(@Param("orderId") Long orderId);
	
	@Query("select sum(o.totalPrice) from Orders o where o.creationDate between :cdate AND :cdateEnd")
	 public Long getTotalAmount(@Param("cdate") Date cdate , @Param("cdateEnd") Date cdateEnd);
	
	@Query("select o from Orders o where o.creationDate between :cdate AND :cdateEnd AND o.deliveryId = :cdeliveryID")
	 public List<Orders> getOrderFromToDateByDeliveryID(@Param("cdate") Date cdate , @Param("cdateEnd") Date cdateEnd , @Param("cdeliveryID") Long cdeliveryID);

	@Query("select o from Orders o where o.creationDate between :cdate AND :cdateEnd AND o.userId = :cuserID")
	 public List<Orders> getOrderFromToDateByCasherID(@Param("cdate") Date cdate , @Param("cdateEnd") Date cdateEnd , @Param("cuserID") Long cuserID);

}
