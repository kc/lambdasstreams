package com.example.streams.pubsdb.domain.model;

import com.example.streams.pubsdb.domain.model.helpers.Idable;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * The persistent class for the roysched database table.
 */

public class Roysched implements Serializable, Idable<String> {
    private static final long serialVersionUID = 1L;

    private String id;

    private BigDecimal hirange;

    private BigDecimal lorange;

    private BigDecimal royalty;

    //bi-directional many-to-one association to Title

    private Title title;

    public Roysched() {
    }

    public Roysched(String id, String hirange, String lorange, String royalty) {
        super();
        this.id = id;
        this.hirange = new BigDecimal(hirange);
        this.lorange = new BigDecimal(lorange);
        this.royalty = new BigDecimal(royalty);
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BigDecimal getHirange() {
        return this.hirange;
    }

    public void setHirange(BigDecimal hirange) {
        this.hirange = hirange;
    }

    public BigDecimal getLorange() {
        return this.lorange;
    }

    public void setLorange(BigDecimal lorange) {
        this.lorange = lorange;
    }

    public BigDecimal getRoyalty() {
        return this.royalty;
    }

    public void setRoyalty(BigDecimal royalty) {
        this.royalty = royalty;
    }

    public Title getTitle() {
        return this.title;
    }

    public void setTitle(Title title) {
        this.title = title;
    }
}
