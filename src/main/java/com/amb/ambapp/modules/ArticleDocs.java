package com.amb.ambapp.modules;

import javax.persistence.*;
import java.io.File;

@Entity
@Table(name="ArticleDocs")
public class ArticleDocs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "articleId")
    private Articles articles;

    @Column(name="photo")
    private File photo;

    public ArticleDocs(int id, File photo, Articles articles) {
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
