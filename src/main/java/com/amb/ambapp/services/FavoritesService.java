package com.amb.ambapp.services;
import com.amb.ambapp.modules.Favorites;
import com.amb.ambapp.repositories.FavoritesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import javax.transaction.Transactional;
import java.util.List;



@Service
public class FavoritesService {
    private FavoritesRepository favoritesRepository;

    @Autowired
    public FavoritesService(FavoritesRepository favoritesRepository) {
        this.favoritesRepository = favoritesRepository;
    }

    public List<Favorites> getFavorites() {
        return favoritesRepository.findAll();
    }

    public void addNewFavorite(Favorites favorites) {
        favoritesRepository.save(favorites);
    }

    public void deleteFavorites(int Id) {
        Boolean FavoriteExists = favoritesRepository.existsById(Id);
        if (!FavoriteExists) {
            throw new IllegalStateException("Favorites with Id:" + Id + " does not exists");
        }
        favoritesRepository.deleteById(Id);
    }
    @Transactional
    public void updateFavorites(int id, int userId) {
        Favorites favorites = favoritesRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Favorites with Id " + id + " does not exists"));

            if (userId != 0 && !favorites.getUserId().equals(userId)) {
                favorites.setUserId(userId);
        }


    }






}
