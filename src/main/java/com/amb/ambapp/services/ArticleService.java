package com.amb.ambapp.services;


import com.amb.ambapp.modules.Articles;
import com.amb.ambapp.modules.Users;
import com.amb.ambapp.repositories.ArticleRepository;
import com.amb.ambapp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Service
public class ArticleService {
    private ArticleRepository articleRepository;

    @Autowired
    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    public List<Articles> getArticles() {
        return articleRepository.findAll();
    }
    public void addNewArticle(Articles article) {
        articleRepository.save(article);
    }

    public void deleteArticle(int Id) {
        Boolean ArticleExists = articleRepository.existsById(Id);
        if (!ArticleExists) {
            throw new IllegalStateException("Article with Id:" + Id + " does not exists");
        }
        articleRepository.deleteById(Id);
    }

    @Transactional
    public void updateArticle(int id, String title, String description, Double price, Date publishDate) {
        Articles article = articleRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Article with Id " + id + " does not exists"));
        if (price != null && !(price == 0) && !(article.getPrice() == price)) {
            article.setPrice(price);}
            if (title != null  && !(article.getTitle() == title)) {
                article.setTitle(title);
        }
        if (description != null  && !(article.getDescription() == description)) {
            article.setDescription(description);
        }
        if (publishDate != null  && !(article.getPublishDate() == publishDate)) {
            article.setPublishDate(publishDate);
        }


    }
    public void updateArticleByAdmin(int id,int valid){
        Articles article = articleRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Article with Id " + id + " does not exists"));
        if(valid==0){
            article.setValid(0);
        }
        if(valid==1){
            article.setValid(1);
        }



    }


    }





