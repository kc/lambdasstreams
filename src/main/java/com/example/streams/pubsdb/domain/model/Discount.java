package com.example.streams.pubsdb.domain.model;

import com.example.streams.pubsdb.domain.model.helpers.Idable;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * The persistent class for the discount database table.
 * 
 */


public class Discount implements Serializable, Idable<String> {
	private static final long serialVersionUID = 1L;

	
	
	private String id;

	private BigDecimal discount;

	private String discounttype;

	private BigDecimal highqty;

	private BigDecimal lowqty;

	//bi-directional many-to-one association to Store
	
	
	private Store store;

	public Discount() {
	}

	public Discount(String id, String discount, String discountType, String highqty, String lowqty) {
		this.id=id;
		this.discount=new BigDecimal(discount);
		this.discounttype=discountType;
		this.highqty= (highqty==null)? null :new BigDecimal(highqty);
		this.lowqty=(lowqty==null)? null :new BigDecimal(lowqty);
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public BigDecimal getDiscount() {
		return this.discount;
	}

	public void setDiscount(BigDecimal discount) {
		this.discount = discount;
	}

	public String getDiscounttype() {
		return this.discounttype;
	}

	public void setDiscounttype(String discounttype) {
		this.discounttype = discounttype;
	}

	public BigDecimal getHighqty() {
		return this.highqty;
	}

	public void setHighqty(BigDecimal highqty) {
		this.highqty = highqty;
	}

	public BigDecimal getLowqty() {
		return this.lowqty;
	}

	public void setLowqty(BigDecimal lowqty) {
		this.lowqty = lowqty;
	}

	public Store getStore() {
		return this.store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

}
