
package com.restaurant.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restaurant.model.eo.Ingrediantes;

public interface IngrediantesRepository extends JpaRepository<Ingrediantes, Long> {

}
