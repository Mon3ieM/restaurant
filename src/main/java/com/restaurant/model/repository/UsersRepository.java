package com.restaurant.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restaurant.model.eo.Users;

public interface UsersRepository extends JpaRepository<Users, Long> {

}
