package com.example.streams.pubsdb.domain.model;

import com.example.streams.pubsdb.domain.model.helpers.Idable;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Author implements Serializable, Idable<String> {
    private static final long serialVersionUID = 1L;

    private String id;

    private String address;

    private String firstname;

    private String lastname;

    private String city;

    private BigDecimal contract;

    private String phone;

    private String state;

    private String zip;

    //bi-directional many-to-one association to Titleauthor
    private List<TitleAuthor> titleauthors = new ArrayList<TitleAuthor>();

    public Author() {
    }

    public Author(String id, String address, String firstname, String lastname, String city, String contract,
                  String phone, String state, String zip) {
        super();
        this.id = id;
        this.address = address;
        this.firstname = firstname;
        this.lastname = lastname;
        this.city = city;
        this.contract = new BigDecimal(contract);
        this.phone = phone;
        this.state = state;
        this.zip = zip;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getFirstname() {
        return this.firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return this.lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public BigDecimal getContract() {
        return this.contract;
    }

    public void setContract(BigDecimal contract) {
        this.contract = contract;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getState() {
        return this.state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return this.zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public List<TitleAuthor> getTitleauthors() {
        return this.titleauthors;
    }

    public void setTitleauthors(List<TitleAuthor> titleauthors) {
        this.titleauthors = titleauthors;
    }

    public TitleAuthor addTitleauthor(TitleAuthor titleauthor) {
        getTitleauthors().add(titleauthor);
        titleauthor.setAuthor(this);

        return titleauthor;
    }

    public TitleAuthor removeTitleauthor(TitleAuthor titleauthor) {
        getTitleauthors().remove(titleauthor);
        titleauthor.setAuthor(null);

        return titleauthor;
    }

    @Override public String toString() {
        return "Author{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }
}
