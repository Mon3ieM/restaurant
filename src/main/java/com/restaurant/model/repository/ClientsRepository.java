package com.restaurant.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.restaurant.model.eo.Clients;

@Repository
public interface ClientsRepository extends JpaRepository<Clients, Long> {

	 

	List<Clients> findByMobile1(String mobile1);
	List<Clients> findByMobile2(String mobile2);
	

}
