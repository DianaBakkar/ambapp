package com.amb.ambapp.modules;

import javax.persistence.*;
import java.io.File;

@Entity
@Table
public class Article_Docs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "articleId",nullable = false)
    private Articles articles;

    private File photo;

    public Article_Docs(int id, int articleId, File photo,Articles articles) {
        this.id = id;
        this.articles = articles;
        this.photo = photo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Articles getArticleId() {
        return articles;
    }

    public void setArticleId(Articles articleId) {
        this.articles = articles;
    }

    public File getPhoto() {
        return photo;
    }

    public void setPhoto(File photo) {
        this.photo = photo;
    }
}
