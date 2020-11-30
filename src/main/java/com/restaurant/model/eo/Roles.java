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
@Getter @Setter @NoArgsConstructor
public class Roles {
    @Id
    @Column(nullable = false)
    private BigDecimal id;
    private String name;

  
}
