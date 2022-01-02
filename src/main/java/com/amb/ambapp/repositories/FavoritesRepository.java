package com.amb.ambapp.repositories;

import com.amb.ambapp.modules.Favorites;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
@Repository
public interface FavoritesRepository extends JpaRepository<Favorites,Integer> {

}
