package com.amb.ambapp.modules;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="Articles")
public class Articles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    private String description;
    private double price;
    private Date publishDate;
    private int valid;
    private String title;



    @ManyToOne
    @JoinColumn(name = "typeId")
    private ArticleTypes typeId;


    @OneToMany(mappedBy = "articles")
    private List<Favorites> favorites;

    @OneToMany(mappedBy = "articles")
    private List<ArticleDocs> article_docs;


    public Articles(int id, ArticleTypes typeId, String description, int price, Date publishDate, int valid, String title) {
        this.id = id;
        this.typeId = typeId;
        this.description = description;
        this.price = price;
        this.publishDate = publishDate;
        this.valid = valid;
        this.title=title;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArticleTypes getTypeId() {
        return typeId;
    }

    public void setTypeId(ArticleTypes typeId) {
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

    public int getValid() {
        return valid;
    }

    public void setValid(int valid) {
        this.valid = valid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
