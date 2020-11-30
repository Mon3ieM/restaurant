package com.restaurant.model.eo;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * To create ID generator sequence "USERS_ID_SEQ_GEN":
 * CREATE SEQUENCE "USERS_ID_SEQ_GEN" INCREMENT BY 50 START WITH 50;
 */
@Entity
@Getter @Setter @NoArgsConstructor
public class Users {
    @Column(name = "FULL_NAME")
    private String fullName;
    @Id
    private BigDecimal id;
    @Column(name = "IS_ACTIVE")
    private BigDecimal isActive;
    @Column(length = 15)
    private String password;
    @Column(name = "ROLE_ID")
    private BigDecimal roleId;
    @Column(name = "USER_NAME")
    private String userName;
 
   
}
