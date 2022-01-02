package com.amb.ambapp.modules;
import org.apache.catalina.User;

import javax.persistence.*;
@Entity
@Table
public class Favorites {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "articleId",nullable = false)
    private Articles articles;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "userId",nullable = false)
    private Users user;

    public Favorites(int id, int articleId, Articles articles,Users user) {
        this.id = id;
        this.articles = articles;
        this.user = user;
    }

    public int getId() {return id;}

    public void setId(int id) {this.id = id;}

    public Articles getArticleId() {return articles;}

    public void setArticleId( ) {this.articles = articles;}

    public Users getUserId() {return user;}

    public void setUserId(int userId) {this.user = user;}
}
