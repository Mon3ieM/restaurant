package com.restaurant.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.restaurant.model.eo.Clients;

@Repository
public interface ClientsRepository extends JpaRepository<Clients, Long> {

}
