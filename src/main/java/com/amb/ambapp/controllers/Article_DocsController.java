package com.amb.ambapp.controllers;


import com.amb.ambapp.modules.Article_Docs;
import com.amb.ambapp.services.Article_DocsService;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/article_docs")
public class Article_DocsController {
    private Article_DocsService article_docsService;
    public Article_DocsController(Article_DocsService article_docsService) {this.article_docsService = article_docsService;}


    @PostMapping
    public void registerNewArticle_Docs(@RequestBody Article_Docs article_docs) {
        article_docsService.addNewArticle_Docs(article_docs);
    }
    @DeleteMapping(path = "{id}")
    public void deleteArticle_Docs(@PathVariable("id") int id) {article_docsService.deleteArticle_Docs(id);}
    @GetMapping
    public List<Article_Docs> getArticle_Docs() {
        return article_docsService.getArticle_Docs();
    }
    @PutMapping(path = "{id}")
    public void updateUser(@PathVariable("id") int id, @RequestParam(required = false) File photo) {
        article_docsService.updateArticle_Docs(id,photo);
    }
}
