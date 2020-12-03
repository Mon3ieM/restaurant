package com.restaurant.model.eo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

/**
 * To create ID generator sequence "USERS_ID_SEQ_GEN":
 * CREATE SEQUENCE "USERS_ID_SEQ_GEN" INCREMENT BY 50 START WITH 50;
 */
@Entity
@Data
public class Users {
    @Column(name = "FULL_NAME")
    private String fullName;
    @Id
    private Long id;
    @Column(name = "IS_ACTIVE")
    private Long isActive;
    @Column(length = 15)
    private String password;
    @Column(name = "ROLE_ID")
    private Long roleId;
    @Column(name = "USER_NAME")
    private String userName;
 
   
}
