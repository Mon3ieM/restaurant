
package com.restaurant.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restaurant.model.eo.Store;

public interface StoreRepository extends JpaRepository<Store, Long> {

}
