package com.amb.ambapp.controllers;

import com.amb.ambapp.modules.AppUser;
import com.amb.ambapp.modules.Articles;
import com.amb.ambapp.services.FavoritesService;
import com.amb.ambapp.modules.Favorites;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/favorites")
public class FavoritesController {
    private FavoritesService favoritesService;
    public FavoritesController(FavoritesService favoritesService) {this.favoritesService = favoritesService;}

    //@PostMapping
    //public void registerNewFavorites(@RequestBody Favorites favorites) {
       // favoritesService.addNewFavorite(favorites);
    //}

    @PostMapping
    public void addToFav(@RequestParam AppUser user, @RequestParam Articles article ){favoritesService.addToFav(user,article);}

    @DeleteMapping(path = "{id}")
    public void deleteFavorites(@PathVariable("id") int id) {
        favoritesService.deleteFavorites(id);
    }

   // @GetMapping
    //public List<Favorites> getFavorites() {
        //return favoritesService.getFavorites();
   // }
   @GetMapping
   public List<Favorites> returnFavByUser(@RequestParam AppUser  user) {
      return favoritesService.returnFavByUser(user);
   }

    @PutMapping(path = "{id}")
    public void updateFavorites(@PathVariable("id") int id, @RequestParam(required = false) int userId) {
        favoritesService.updateFavorites(id,userId);
    }






}
