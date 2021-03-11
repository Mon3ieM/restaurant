package com.restaurant.model.eo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@SequenceGenerator(name = "FOOD_PRICES_Seq_Gen", sequenceName = "FOOD_PRICES_SEQ",
allocationSize = 1, initialValue = 1)
@Table(name = "FOOD_PRICES")
public class FoodPrices {

	
	@Column(name = "FOOD_SIZE_ID")
	private Long foodSizeId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "FOOD_SIZE_ID" , insertable = false , updatable = false)
	private FoodSize foodSizeEO;

	@Id
	@Column(nullable = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "FOOD_PRICES_Seq_Gen")
	private Long id;
	
	@Column(name = "FOOD_Menu_ID")
	private Long foodMenuId;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "FOOD_Menu_ID" , insertable = false , updatable = false)
	private FoodMenu foodMenuEO;
	
	public FoodSize getFoodSizeEO() {
		return foodSizeEO;
	}

	public void setFoodSizeEO(FoodSize foodSizeEO) {
		this.foodSizeEO = foodSizeEO;
	}

	public FoodMenu getFoodMenuEO() {
		return foodMenuEO;
	}

	public void setFoodMenuEO(FoodMenu foodMenuEO) {
		this.foodMenuEO = foodMenuEO;
	}

	private Long price;

	public Long getFoodSizeId() {
		return foodSizeId;
	}

	public void setFoodSizeId(Long foodSizeId) {
		this.foodSizeId = foodSizeId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getFoodMenuId() {
		return foodMenuId;
	}

	public void setFoodMenuId(Long foodMenuId) {
		this.foodMenuId = foodMenuId;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}



}
