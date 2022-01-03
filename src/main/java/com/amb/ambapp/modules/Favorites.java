package com.amb.ambapp.modules;


import javax.persistence.*;
@Entity
@Table(name = "Favorites")
public class Favorites {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @ManyToOne
    @JoinColumn(name = "articleId")
    private Articles articles;

    @ManyToOne
    @JoinColumn(name = "userId")
    private AppUser user;

    public Favorites(int id, Articles articles,AppUser user) {
        this.id = id;
        this.articles = articles;
        this.user = user;
    }

    public int getId() {return id;}

    public void setId(int id) {this.id = id;}

    public Articles getArticleId() {return articles;}

    public void setArticleId( ) {this.articles = articles;}

    public AppUser getUserId() {return user;}

    public void setUserId(int userId) {this.user = user;}
}
