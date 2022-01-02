package com.amb.ambapp.services;

import com.amb.ambapp.modules.Article_Docs;;
import com.amb.ambapp.repositories.Article_DocsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.io.File;
import java.util.List;

@Service
public class Article_DocsService {
    private Article_DocsRepository article_docsRepository;

    @Autowired
    public Article_DocsService(Article_DocsRepository article_docsRepository) {
        this.article_docsRepository = article_docsRepository;
    }
    public List<Article_Docs> getArticle_Docs() {
        return article_docsRepository.findAll();
    }
    public void addNewArticle_Docs(Article_Docs article_docs) {
        article_docsRepository.save(article_docs);
    }
    public void deleteArticle_Docs(int Id) {
        Boolean Article_DocsExists = article_docsRepository.existsById(Id);
        if (!Article_DocsExists) {
            throw new IllegalStateException("Article_Docs with Id:" + Id + " does not exists");
        }
        article_docsRepository.deleteById(Id);
    }
    @Transactional
    public void updateArticle_Docs(int id, File photo) {
        Article_Docs article_docs = article_docsRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Photo with Id " + id + " does not exists"));
        if (photo != null  && !article_docs.getPhoto().equals(photo)) {
            article_docs.setPhoto(photo);
        }


    }



}
