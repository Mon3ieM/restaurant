package com.restaurant.model.eo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Entity
@Table(name = "FOOD_CATEGORY")
public class FoodCategory{
    @Id
    @Column(nullable = false)
    private Long id;
    @Column(name = "IS_ACTIVE")
    private Long isActive;
    private String name;
    
    @OneToMany(mappedBy="foodCategoryId")
    private List<FoodMenu> foodMenuList = new ArrayList<>();
 
 

}
