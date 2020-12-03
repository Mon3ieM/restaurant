package com.restaurant.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.restaurant.model.eo.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {

	@Query("select u from Users u where u.userName = :username and u.password = :password and u.isActive = 1")
	public Users findByUsernameAndPassword(@Param("username") String username, @Param("password") String password);

}
