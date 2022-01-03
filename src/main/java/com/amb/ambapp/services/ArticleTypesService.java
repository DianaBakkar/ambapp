package com.amb.ambapp.services;

import com.amb.ambapp.modules.ArticleTypes;
import com.amb.ambapp.repositories.Article_TypesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ArticleTypesService {
    private Article_TypesRepository article_typesRepository;

    @Autowired
    public ArticleTypesService(Article_TypesRepository article_typesRepository) {
        this.article_typesRepository = article_typesRepository;
    }
    public List<ArticleTypes> getArticle_Types() {
        return article_typesRepository.findAll();
    }

    public void addNewArticle_Types(ArticleTypes article_Types) {article_typesRepository.save(article_Types);
    }

    public void deleteArticle_Type(int Id) {
        Boolean Article_TypeExists = article_typesRepository.existsById(Id);
        if (!Article_TypeExists) {
            throw new IllegalStateException("Article Type with Id:" + Id + " does not exists");
        }
        article_typesRepository.deleteById(Id);
    }

    @Transactional
    public void updateArticle_Type(int id, String label) {
        ArticleTypes article_types = article_typesRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Article Type with Id " + id + " does not exists"));
        if (label != null && !label.isEmpty() && !article_types.getLabel().equals(label)) {
            article_types.setLabel(label);
        }


    }






}
