package com.restaurant.model.eo;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "FOOD_SIZE")
@SequenceGenerator(name = "FoodSize_Seq_Gen", sequenceName = "Food_Size_SEQ",
allocationSize = 1, initialValue = 1)
public class FoodSize {
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "FoodSize_Seq_Gen")
    private Long id;
    private String name;
    @Column(name = "IS_ACTIVE")
    private Long isActive;
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
	public Long getIsActive() {
		return isActive;
	}
	public void setIsActive(Long isActive) {
		this.isActive = isActive;
	}


    
}
