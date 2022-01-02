package com.amb.ambapp.controllers;


import com.amb.ambapp.modules.Articles;
import com.amb.ambapp.modules.Users;
import com.amb.ambapp.services.ArticleService;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/articles")
public class ArticlesController {
    private ArticleService articleService;
    public ArticlesController(ArticleService articleService) {this.articleService = articleService;}
    @PostMapping
    public void registerNewArticle(@RequestBody Articles article) {articleService.addNewArticle(article);}
    @DeleteMapping(path = "{id}")
    public void deleteArticle(@PathVariable("id") int id) {
        articleService.deleteArticle(id);
    }
    @GetMapping
    public List<Articles> getArticles() {
        return articleService.getArticles();
    }
    @PutMapping(path = "{id}")
    public void updateArticle(@PathVariable("id") int id, @RequestParam(required = false) Double price,String title,String description,Date publishDate) {
        articleService.updateArticle(id,title,description, price, publishDate);
    }






}
