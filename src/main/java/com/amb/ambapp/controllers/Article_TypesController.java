package com.amb.ambapp.controllers;

import com.amb.ambapp.modules.Article_Types;
import com.amb.ambapp.modules.Users;
import com.amb.ambapp.services.Article_TypesService;
import com.amb.ambapp.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/article_types")
public class Article_TypesController {
    private Article_TypesService article_typesService;
    public Article_TypesController(Article_TypesService article_typesService) {this.article_typesService = article_typesService;}
    @PostMapping
    public void registerNewArticle_Types(@RequestBody Article_Types article_types) {
        article_typesService.addNewArticle_Types(article_types);
    }
    @DeleteMapping(path = "{id}")
    public void deleteArticle(@PathVariable("id") int id) {
        article_typesService.deleteArticle_Type(id);
    }
    @GetMapping
    public List<Article_Types> getArticle_Types() {
        return article_typesService.getArticle_Types();
    }
    @PutMapping(path = "{id}")
    public void updateArticle_Types(@PathVariable("id") int id, @RequestParam(required = false) String label) {
        article_typesService.updateArticle_Type(id,label);
    }

}
