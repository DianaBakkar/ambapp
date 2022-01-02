package com.amb.ambapp.repositories;


import com.amb.ambapp.modules.Articles;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
@Repository
public interface ArticleRepository extends JpaRepository<Articles,Integer>{
}
