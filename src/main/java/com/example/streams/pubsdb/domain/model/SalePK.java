package com.example.streams.pubsdb.domain.model;

import java.io.Serializable;

/**
 * The primary key class for the sale database table.
 * 
 */

public class SalePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	
	private String orderNumber;

	
	private String storeId;

	
	private String titleId;

	public SalePK() {
	}
	public SalePK(String orderNumber, String storeId, String titleId) {
		this.orderNumber=orderNumber;
		this.storeId=storeId;
		this.titleId=titleId;
	}
	public String getOrderNumber() {
		return this.orderNumber;
	}
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
	public String getStoreId() {
		return this.storeId;
	}
	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}
	public String getTitleId() {
		return this.titleId;
	}
	public void setTitleId(String titleId) {
		this.titleId = titleId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof SalePK)) {
			return false;
		}
		SalePK castOther = (SalePK)other;
		return 
			this.orderNumber.equals(castOther.orderNumber)
			&& this.storeId.equals(castOther.storeId)
			&& this.titleId.equals(castOther.titleId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.orderNumber.hashCode();
		hash = hash * prime + this.storeId.hashCode();
		hash = hash * prime + this.titleId.hashCode();
		
		return hash;
	}
	
	public String toString() {
		return orderNumber + "_" + storeId + "_" + titleId;
	}
}
