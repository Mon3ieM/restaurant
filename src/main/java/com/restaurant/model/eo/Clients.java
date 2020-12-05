package com.restaurant.model.eo;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;





@Entity
public class Clients {
    private String address;
    @Column(name = "BLOCKED_REASON")
    private String blockedReason;
    @Column(nullable = false)
    @Id
    private Long id;
    @Column(name = "IS_ACTIVE")
    private Long isActive;
    @Column(name = "IS_BLOCKED")
    private Long isBlocked;
    @Column(length = 20)
    private String mobile1;
    @Column(length = 20)
    private String mobile2;
    private String name;
    private String notes;
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getBlockedReason() {
		return blockedReason;
	}
	public void setBlockedReason(String blockedReason) {
		this.blockedReason = blockedReason;
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
	public Long getIsBlocked() {
		return isBlocked;
	}
	public void setIsBlocked(Long isBlocked) {
		this.isBlocked = isBlocked;
	}
	public String getMobile1() {
		return mobile1;
	}
	public void setMobile1(String mobile1) {
		this.mobile1 = mobile1;
	}
	public String getMobile2() {
		return mobile2;
	}
	public void setMobile2(String mobile2) {
		this.mobile2 = mobile2;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	
}
