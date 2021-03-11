package com.restaurant.model.eo;

<<<<<<< HEAD
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
=======
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
>>>>>>> 95427e7b70ec812f9d113fa19c90a374f0daabc9
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@SequenceGenerator(name = "FOOD_PRICES_Seq_Gen", sequenceName = "FOOD_PRICES_SEQ",
allocationSize = 1, initialValue = 1)
@Table(name = "FOOD_PRICES")
public class FoodPrices {

	
	@Column(name = "FOOD_SIZE_ID")
	private Long foodSizeId;
<<<<<<< HEAD
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "FOOD_SIZE_ID" , insertable = false , updatable = false)
	private FoodSize foodSizeEO;
=======
>>>>>>> 95427e7b70ec812f9d113fa19c90a374f0daabc9

	@Id
	@Column(nullable = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "FOOD_PRICES_Seq_Gen")
	private Long id;
	
	@Column(name = "FOOD_Menu_ID")
	private Long foodMenuId;
	
<<<<<<< HEAD
	
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

=======
>>>>>>> 95427e7b70ec812f9d113fa19c90a374f0daabc9
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
