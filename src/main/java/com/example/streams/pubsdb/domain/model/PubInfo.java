package com.example.streams.pubsdb.domain.model;

import com.example.streams.pubsdb.domain.model.helpers.Idable;

import java.io.Serializable;

/**
 * The persistent class for the pub_info database table.
 */

public class PubInfo implements Serializable, Idable<String> {
    private static final long serialVersionUID = 1L;

    private String id;

    private byte[] logo;

    private String prInfo;

    private Publisher publisher;

    public PubInfo() {
    }

    public PubInfo(String id, String prInfo) {
        super();
        this.id = id;
        this.prInfo = prInfo;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Object getLogo() {
        return this.logo;
    }

    public void setLogo(byte[] logo) {
        this.logo = logo;
    }

    public Object getPrInfo() {
        return this.prInfo;
    }

    public void setPrInfo(String prInfo) {
        this.prInfo = prInfo;
    }

    public Publisher getPublisher() {
        return this.publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }
}
