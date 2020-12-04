<<<<<<< HEAD
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
    public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getIsActive() {
		return isActive;
	}
	public void setIsActive(Long isActive) {
		this.isActive = isActive;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Long getRoleId() {
		return roleId;
	}
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
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
=======
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
>>>>>>> b3d2918749489da462ad5ffe54d309a536e314bb
