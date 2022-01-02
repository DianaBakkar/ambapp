package com.amb.ambapp.repositories;

import com.amb.ambapp.modules.Types;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
@Repository
public interface TypesRepository extends JpaRepository<Types,Integer>{
}
