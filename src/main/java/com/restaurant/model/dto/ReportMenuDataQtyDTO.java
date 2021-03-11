package com.restaurant.model.dto;

import java.math.BigDecimal;
import java.math.BigInteger;

public class ReportMenuDataQtyDTO {

	private BigDecimal qty;
	private BigInteger sizeId;
	private String itemname;
	private BigInteger price;
	private BigDecimal total;

	public BigDecimal getQty() {
		return qty;
	}

	public void setQty(BigDecimal qty) {
		this.qty = qty;
	}

	public BigInteger getSizeId() {
		return sizeId;
	}

	public void setSizeId(BigInteger sizeId) {
		this.sizeId = sizeId;
	}

	public String getItemname() {
		return itemname;
	}

	public void setItemname(String itemname) {
		this.itemname = itemname;
	}

	public BigInteger getPrice() {
		return price;
	}

	public void setPrice(BigInteger price) {
		this.price = price;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public String getSizeName() {
		if (sizeId != null) {
			if (sizeId.equals(BigInteger.valueOf(1L)))
				sizeName = "Small";
			else if (sizeId.equals(BigInteger.valueOf(2L)))
				sizeName = "Meduim";
			else if (sizeId.equals(BigInteger.valueOf(3L)))
				sizeName = "Larg";
			else
				sizeName = "";
		}
		return sizeName;
	}

	private String sizeName;

}
