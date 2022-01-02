package com.amb.ambapp.services;


import com.amb.ambapp.modules.Articles;
import com.amb.ambapp.modules.Users;
import com.amb.ambapp.repositories.ArticleRepository;
import com.amb.ambapp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class AdminService {
    private UserRepository userRepository;
    private ArticleRepository articleRepository;

    @Autowired
    public AdminService(UserRepository userRepository,ArticleRepository articleRepository){
        this.userRepository=userRepository;
        this.articleRepository=articleRepository;
    }



    @Transactional
    public void updateArticleByAdmin(int id,int valid) {
        Articles article = articleRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Article with Id " + id + " does not exists"));
        if (valid == 0) {
            article.setValid(0);
        }
        if (valid == 1) {
            article.setValid(1);
        }
    }

    public void deleteArticleByAdmin(int Id) {
        Boolean ArticleExists = articleRepository.existsById(Id);
        if (!ArticleExists) {
            throw new IllegalStateException("Article with Id:" + Id + " does not exists");
        }
        articleRepository.deleteById(Id);
    }
    public void updateUserByAdmin(int id,int valid){
        Users user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("User with Id " + id + " does not exists"));
        if(valid==0){
            user.setValid(0);
        }
        if(valid==1){
            user.setValid(1);
        }
    }

    public void deleteUserByAdmin(int Id) {
        Boolean UserExists = userRepository.existsById(Id);
        if (!UserExists) {
            throw new IllegalStateException("User with Id:" + Id + " does not exists");
        }
        userRepository.deleteById(Id);
    }



}
