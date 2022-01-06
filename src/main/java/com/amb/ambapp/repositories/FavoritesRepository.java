package com.amb.ambapp.repositories;


import com.amb.ambapp.modules.AppUser;
import com.amb.ambapp.modules.Favorites;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


@Repository
public interface FavoritesRepository extends JpaRepository<Favorites,Integer> {

    List<Favorites> findAll();
}
