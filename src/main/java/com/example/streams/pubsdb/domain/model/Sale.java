package com.example.streams.pubsdb.domain.model;

import com.example.streams.pubsdb.domain.model.helpers.Idable;
import com.example.streams.pubsdb.domain.model.helpers.MySimpleDateFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * The persistent class for the sale database table.
 */

public class Sale implements Serializable, Idable<SalePK> {
    private static final long serialVersionUID = 1L;

    private SalePK id;

    private Date orderDate;

    private String payterms;

    private BigDecimal quantity;

    //bi-directional many-to-one association to Store

    private Store store;

    //bi-directional many-to-one association to Title

    private Title title;

    public Sale() {
    }

    public Sale(String id, String orderDate, String payterms, String quantity) {
        String[] constructorArgs = id.split("_");
        this.id = new SalePK(constructorArgs[0], constructorArgs[1], constructorArgs[2]);
        this.orderDate = new MySimpleDateFormat().parse(orderDate);
        this.payterms = payterms;
        this.quantity = new BigDecimal(quantity);
    }

    public SalePK getId() {
        return this.id;
    }

    public void setId(SalePK id) {
        this.id = id;
    }

    public Date getOrderDate() {
        return this.orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getPayterms() {
        return this.payterms;
    }

    public void setPayterms(String payterms) {
        this.payterms = payterms;
    }

    public BigDecimal getQuantity() {
        return this.quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public Store getStore() {
        return this.store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public Title getTitle() {
        return this.title;
    }

    public void setTitle(Title title) {
        this.title = title;
    }

    @Override public String toString() {
        return "Sale{" +
                "quantity=" + quantity +
                ", title=" + title +
                '}';
    }
}
