package com.example.streams.pubsdb.domain.model;

import com.example.streams.pubsdb.domain.model.helpers.Idable;
import com.example.streams.pubsdb.domain.model.helpers.MySimpleDateFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static java.util.stream.Collectors.joining;

/**
 * The persistent class for the title database table.
 */

public class Title implements Serializable, Idable<String> {
    private static final long serialVersionUID = 1L;

    private String id;

    private BigDecimal advance;

    private String notes;

    private BigDecimal price;

    private Date pubdate;

    private BigDecimal royalty;

    private String title;

    private String type;

    private BigDecimal ytdSale;

    //bi-directional many-to-one association to Roysched

    private List<Roysched> royscheds = new ArrayList<Roysched>();

    //bi-directional many-to-one association to Sale

    private List<Sale> sales = new ArrayList<Sale>();

    //bi-directional many-to-one association to Publisher

    private Publisher publisher;

    //bi-directional many-to-one association to Titleauthor

    private List<TitleAuthor> titleauthors = new ArrayList<>();
    ;

    public Title() {
    }

    public Title(String id, String advance, String notes, String price, String pubdate, String royalty,
                 String title, String type, String ytdSale) {
        super();
        this.id = id;
        this.advance = (advance != null ? new BigDecimal(advance) : null);
        this.notes = notes;
        this.price = (price != null ? new BigDecimal(price) : null);
        this.pubdate = new MySimpleDateFormat().parse(pubdate);
        this.royalty = royalty != null ? new BigDecimal(royalty) : null;
        this.title = title;
        this.type = type;
        this.ytdSale = ytdSale != null ? new BigDecimal(ytdSale) : null;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BigDecimal getAdvance() {
        return this.advance;
    }

    public void setAdvance(BigDecimal advance) {
        this.advance = advance;
    }

    public String getNotes() {
        return this.notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Date getPubdate() {
        return this.pubdate;
    }

    public void setPubdate(Date pubdate) {
        this.pubdate = pubdate;
    }

    public BigDecimal getRoyalty() {
        return this.royalty;
    }

    public void setRoyalty(BigDecimal royalty) {
        this.royalty = royalty;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public BigDecimal getYtdSale() {
        return this.ytdSale;
    }

    public void setYtdSale(BigDecimal ytdSale) {
        this.ytdSale = ytdSale;
    }

    public List<Roysched> getRoyscheds() {
        return this.royscheds;
    }

    public void setRoyscheds(List<Roysched> royscheds) {
        this.royscheds = royscheds;
    }

    public Roysched addRoysched(Roysched roysched) {
        getRoyscheds().add(roysched);
        roysched.setTitle(this);

        return roysched;
    }

    public Roysched removeRoysched(Roysched roysched) {
        getRoyscheds().remove(roysched);
        roysched.setTitle(null);

        return roysched;
    }

    public List<Sale> getSales() {
        return this.sales;
    }

    public void setSales(List<Sale> sales) {
        this.sales = sales;
    }

    public Sale addSale(Sale sale) {
        getSales().add(sale);
        sale.setTitle(this);

        return sale;
    }

    public Sale removeSale(Sale sale) {
        getSales().remove(sale);
        sale.setTitle(null);

        return sale;
    }

    public Publisher getPublisher() {
        return this.publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public List<TitleAuthor> getTitleauthors() {
        return this.titleauthors;
    }

    public void setTitleauthors(List<TitleAuthor> titleauthors) {
        this.titleauthors = titleauthors;
    }

    public TitleAuthor addTitleauthor(TitleAuthor titleauthor) {
        getTitleauthors().add(titleauthor);
        titleauthor.setTitle(this);

        return titleauthor;
    }

    public TitleAuthor removeTitleauthor(TitleAuthor titleauthor) {
        getTitleauthors().remove(titleauthor);
        titleauthor.setTitle(null);

        return titleauthor;
    }

    @Override public String toString() {
        String titleAuthors = titleauthors.stream().map(TitleAuthor::toString).collect(joining(", "));
        return "Title{" +
                "title='" + title + '\'' +
                ", titleauthors=" + titleAuthors +
                '}';
    }
}
