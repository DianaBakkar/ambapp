package com.amb.ambapp.repositories;

import com.amb.ambapp.modules.Article_Types;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface Article_TypesRepository extends JpaRepository<Article_Types,Integer> {
}
