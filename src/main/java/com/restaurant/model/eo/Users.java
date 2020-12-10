
package com.restaurant.model.eo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;


@Entity
@SequenceGenerator(name = "Users_Seq_Gen", sequenceName = "Users_SEQ",
allocationSize = 1, initialValue = 1)
public class Users {
    @Column(name = "FULL_NAME")
    private String fullName;
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Users_Seq_Gen")
    private Long id;
    @Column(name = "IS_ACTIVE")
    private Long isActive;
    @Column(length = 15)
    private String password;
    @Column(name = "ROLE_ID")
    private Long roleId;
    @Column(name = "USER_NAME")
    private String userName;
	
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

    
   
}
