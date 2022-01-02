package com.amb.ambapp.modules;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
public class Articles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    private String description;
    private double price;
    private Date publishDate;
    private int status;
    private String title;
    private int valid;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "typeId",nullable = false)
    private Article_Types typeId;


    @ManyToOne(fetch = FetchType.LAZY,optional=false)
    @JoinColumn(name = "articleId")
    private Favorites favorites;

    @ManyToOne(fetch = FetchType.LAZY,optional=false)
    @JoinColumn(name = "articleId_docs")
    private Article_Docs article_docs;


    public Articles(int id, Article_Types typeId, String description, int price, Date publishDate, int status, String title,int valid) {
        this.id = id;
        this.typeId = typeId;
        this.description = description;
        this.price = price;
        this.publishDate = publishDate;
        this.status = status;
        this.title=title;
        this.valid=valid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Article_Types getTypeId() {
        return typeId;
    }

    public void setTypeId(Article_Types typeId) {
        this.typeId = typeId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getValid() {
        return valid;
    }

    public void setValid(int valid) {
        this.valid = valid;
    }
}
