package com.example.streams.pubsdb.domain.model;

import com.example.streams.pubsdb.domain.model.helpers.Idable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * The persistent class for the store database table.
 */

public class Store implements Serializable, Idable<String> {
    private static final long serialVersionUID = 1L;

    private String id;

    private String city;

    private String state;

    private String storeAddress;

    private String storeName;

    private String zip;

    //bi-directional many-to-one association to Discount

    private List<Discount> discounts = new ArrayList<Discount>();

    //bi-directional many-to-one association to Sale

    private List<Sale> sales = new ArrayList<Sale>();

    public Store() {
    }

    public Store(String id, String city, String state, String storeAddress, String storeName, String zip) {
        super();
        this.id = id;
        this.city = city;
        this.state = state;
        this.storeAddress = storeAddress;
        this.storeName = storeName;
        this.zip = zip;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return this.state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getStoreAddress() {
        return this.storeAddress;
    }

    public void setStoreAddress(String storeAddress) {
        this.storeAddress = storeAddress;
    }

    public String getStoreName() {
        return this.storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getZip() {
        return this.zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public List<Discount> getDiscounts() {
        return this.discounts;
    }

    public void setDiscounts(List<Discount> discounts) {
        this.discounts = discounts;
    }

    public Discount addDiscount(Discount discount) {
        getDiscounts().add(discount);
        discount.setStore(this);

        return discount;
    }

    public Discount removeDiscount(Discount discount) {
        getDiscounts().remove(discount);
        discount.setStore(null);

        return discount;
    }

    public List<Sale> getSales() {
        return this.sales;
    }

    public void setSales(List<Sale> sales) {
        this.sales = sales;
    }

    public Sale addSale(Sale sale) {
        getSales().add(sale);
        sale.setStore(this);

        return sale;
    }

    public Sale removeSale(Sale sale) {
        getSales().remove(sale);
        sale.setStore(null);

        return sale;
    }
}
