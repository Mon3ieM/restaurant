package com.restaurant.model.eo;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * To create ID generator sequence "ROLES_ID_SEQ_GEN":
 * CREATE SEQUENCE "ROLES_ID_SEQ_GEN" INCREMENT BY 50 START WITH 50;
 */
@Entity
@SequenceGenerator(name = "Roles_Seq_Gen", sequenceName = "Roles_SEQ",
allocationSize = 1, initialValue = 1)
public class Roles {
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Roles_Seq_Gen")
    private Long id;
    private String name;
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
