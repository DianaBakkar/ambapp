package com.amb.ambapp.repositories;

import com.amb.ambapp.modules.Article_Docs;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface Article_DocsRepository extends JpaRepository<Article_Docs,Integer>{
}
