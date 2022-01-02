package com.amb.ambapp.repositories;

import com.amb.ambapp.modules.Users;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface UserRepository extends JpaRepository<Users,Integer> {

}