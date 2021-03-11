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
<<<<<<< HEAD
	
	@Query("select sum(o.totalPrice) from Orders o where o.creationDate between :cdate AND :cdateEnd")
	 public Long getTotalAmount(@Param("cdate") Date cdate , @Param("cdateEnd") Date cdateEnd);
	
	@Query("select o from Orders o where o.creationDate between :cdate AND :cdateEnd AND o.deliveryId = :cdeliveryID")
	 public List<Orders> getOrderFromToDateByDeliveryID(@Param("cdate") Date cdate , @Param("cdateEnd") Date cdateEnd , @Param("cdeliveryID") Long cdeliveryID);

	@Query("select o from Orders o where o.creationDate between :cdate AND :cdateEnd AND o.userId = :cuserID")
	 public List<Orders> getOrderFromToDateByCasherID(@Param("cdate") Date cdate , @Param("cdateEnd") Date cdateEnd , @Param("cuserID") Long cuserID);

	@Query("select o from Orders o where o.creationDate between :cdate AND :cdateEnd ")
	 public List<Orders> getOrderFromToDate(@Param("cdate") Date cdate , @Param("cdateEnd") Date cdateEnd);
	
	@Query(value ="select sum(quantity) as qty,price.food_size_id size,menu.name as itemname,price.price as price, (price.price*sum(quantity)) as total from restaurant.order_items item,\r\n"
			+ "restaurant.food_prices price, restaurant.food_menu menu\r\n"
			+ "where price.id= item.food_price_id  and menu.id=price.food_menu_id  and item.order_id in (select ordd.id from restaurant.orders ordd  where ordd.ceration_date between :date_From and :date_To) group by  item.food_price_id;\r\n"
			+ "" , nativeQuery = true)
	 public List<Object[]> getReportData(@Param("date_From") Date date_From , @Param("date_To") Date date_To);
=======
	
	@Query("select sum(o.totalPrice) from Orders o where o.creationDate between :cdate AND :cdateEnd")
	 public Long getTotalAmount(@Param("cdate") Date cdate , @Param("cdateEnd") Date cdateEnd);
	
	@Query("select o from Orders o where o.creationDate between :cdate AND :cdateEnd AND o.deliveryId = :cdeliveryID")
	 public List<Orders> getOrderFromToDateByDeliveryID(@Param("cdate") Date cdate , @Param("cdateEnd") Date cdateEnd , @Param("cdeliveryID") Long cdeliveryID);

	@Query("select o from Orders o where o.creationDate between :cdate AND :cdateEnd AND o.userId = :cuserID")
	 public List<Orders> getOrderFromToDateByCasherID(@Param("cdate") Date cdate , @Param("cdateEnd") Date cdateEnd , @Param("cuserID") Long cuserID);
>>>>>>> 95427e7b70ec812f9d113fa19c90a374f0daabc9

}
