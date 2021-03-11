package com.restaurant.model.eo;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
<<<<<<< HEAD
import javax.persistence.OneToOne;
=======
>>>>>>> 95427e7b70ec812f9d113fa19c90a374f0daabc9
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@SequenceGenerator(name = "FOOD_MENU_Seq_Gen", sequenceName = "FOOD_MENU_SEQ",
allocationSize = 1, initialValue = 1)
@Table(name = "FOOD_MENU")
public class FoodMenu {


	
	@Column(name = "FOOD_CATEGORY_ID")
	private Long foodCategoryId;
	

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "FOOD_CATEGORY_ID" , insertable = false , updatable = false)
	private FoodCategory foodCategoryEO;
	
	
	@Id
	@Column(nullable = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "FOOD_MENU_Seq_Gen")
	private Long id;

	private String name;
	
	
	
<<<<<<< HEAD
	public FoodCategory getFoodCategoryEO() {
		return foodCategoryEO;
	}
	public void setFoodCategoryEO(FoodCategory foodCategoryEO) {
		this.foodCategoryEO = foodCategoryEO;
	}
=======
	
>>>>>>> 95427e7b70ec812f9d113fa19c90a374f0daabc9
	public Long getFoodCategoryId() {
		return foodCategoryId;
	}
	public void setFoodCategoryId(Long foodCategoryId) {
		this.foodCategoryId = foodCategoryId;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}


	
	
}
