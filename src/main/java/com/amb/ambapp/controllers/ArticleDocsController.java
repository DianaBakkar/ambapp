package com.amb.ambapp.controllers;


import com.amb.ambapp.modules.ArticleDocs;
import com.amb.ambapp.services.ArticleDocsService;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/article_docs")
public class ArticleDocsController {
    private ArticleDocsService article_docsService;
    public ArticleDocsController(ArticleDocsService article_docsService) {this.article_docsService = article_docsService;}


    @PostMapping
    public void registerNewArticle_Docs(@RequestBody ArticleDocs article_docs) {
        article_docsService.addNewArticle_Docs(article_docs);
    }
    @DeleteMapping(path = "{id}")
    public void deleteArticle_Docs(@PathVariable("id") int id) {article_docsService.deleteArticle_Docs(id);}
    @GetMapping
    public List<ArticleDocs> getArticle_Docs() {
        return article_docsService.getArticle_Docs();
    }
    @PutMapping(path = "{id}")
    public void updateUser(@PathVariable("id") int id, @RequestParam(required = false) File photo) {
        article_docsService.updateArticle_Docs(id,photo);
    }
}
