package com.example.streams.pubsdb.domain.model;


import com.example.streams.pubsdb.domain.model.helpers.Idable;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * The persistent class for the titleauthor database table.
 */

public class TitleAuthor implements Serializable, Idable<TitleAuthorPK> {
    private static final long serialVersionUID = 1L;


    private TitleAuthorPK id;


    private BigDecimal authorOrder;

    private BigDecimal royaltyper;

    //bi-directional many-to-one association to Author


    private Author author;

    //bi-directional many-to-one association to Title


    private Title title;

    public TitleAuthor() {
    }


    public TitleAuthor(String id, String authorOrder, String royaltyper) {
        String[] pkConstructorArgs = id.split("_");
        this.id = new TitleAuthorPK(pkConstructorArgs[0], pkConstructorArgs[1]);
        this.authorOrder = new BigDecimal(authorOrder);
        this.royaltyper = new BigDecimal(royaltyper);
    }


    public TitleAuthorPK getId() {
        return this.id;
    }

    public void setId(TitleAuthorPK id) {
        this.id = id;
    }

    public BigDecimal getAuthorOrder() {
        return this.authorOrder;
    }

    public void setAuthorOrder(BigDecimal authorOrder) {
        this.authorOrder = authorOrder;
    }

    public BigDecimal getRoyaltyper() {
        return this.royaltyper;
    }

    public void setRoyaltyper(BigDecimal royaltyper) {
        this.royaltyper = royaltyper;
    }

    public Author getAuthor() {
        return this.author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Title getTitle() {
        return this.title;
    }

    public void setTitle(Title title) {
        this.title = title;
    }

    @Override public String toString() {
        return "TitleAuthor{" +
                "author=" + author +
                '}';
    }
}
