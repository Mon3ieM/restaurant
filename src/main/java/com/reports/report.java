package com.reports;

import java.util.Date;

public class report {

	public report(String id, String name) {
		// TODO Auto-generated constructor stub
		this.setId(id);
		this.setName(name);
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return reportType;
	}
	public void setName(String name) {
		this.reportType = name;
	}
	String id;
	String reportType;
	String casherName;
	public String getCasherName() {
		return casherName;
	}
	public void setCasherName(String casherName) {
		this.casherName = casherName;
	}
	public String getDeliveryName() {
		return deliveryName;
	}
	public void setDeliveryName(String deliveryName) {
		this.deliveryName = deliveryName;
	}
	
	String deliveryName;
	String From;
	public String getReportType() {
		return reportType;
	}
	public void setReportType(String reportType) {
		this.reportType = reportType;
	}
	public String getFrom() {
		return From;
	}
	public void setFrom(String from) {
		From = from;
	}
	public String getTo() {
		return To;
	}
	public void setTo(String to) {
		To = to;
	}
	String To;
	
}
