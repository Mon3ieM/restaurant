package com.restaurant.model.eo;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "FOOD_MENU")
public class FoodMenu {

	@ManyToOne(targetEntity = FoodCategory.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "FOOD_CATEGORY_ID", referencedColumnName = "ID")
	private FoodCategory foodCategoryId;

	@Column(name = "FOOD_SIZE_ID")
	private Long foodSizeId;

	@Id
	@Column(nullable = false)
	private Long id;
	@Column(name = "IS_ACTIVE")
	private Long isActive;
	private String name;
	private Long price;

}
