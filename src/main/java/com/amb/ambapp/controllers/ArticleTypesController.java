package com.amb.ambapp.controllers;

import com.amb.ambapp.modules.ArticleTypes;
import com.amb.ambapp.services.ArticleTypesService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/article_types")
public class ArticleTypesController {
    private ArticleTypesService article_typesService;
    public ArticleTypesController(ArticleTypesService article_typesService) {this.article_typesService = article_typesService;}
    @PostMapping
    public void registerNewArticle_Types(@RequestBody ArticleTypes article_types) {
        article_typesService.addNewArticle_Types(article_types);
    }
    @DeleteMapping(path = "{id}")
    public void deleteArticle(@PathVariable("id") int id) {
        article_typesService.deleteArticle_Type(id);
    }
    @GetMapping
    public List<ArticleTypes> getArticle_Types() {
        return article_typesService.getArticle_Types();
    }
    @PutMapping(path = "{id}")
    public void updateArticle_Types(@PathVariable("id") int id, @RequestParam(required = false) String label) {
        article_typesService.updateArticle_Type(id,label);
    }

}
