package com.amb.ambapp.repositories;
import com.amb.ambapp.modules.Profile;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
@Repository
public interface ProfileRepository extends JpaRepository<Profile,Integer>{
}
