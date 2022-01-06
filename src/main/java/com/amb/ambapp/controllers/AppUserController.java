package com.amb.ambapp.controllers;

import com.amb.ambapp.modules.AppUser;
import com.amb.ambapp.services.AppUserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/appUser")
public class AppUserController {
    private AppUserService appUserService;

    public AppUserController(AppUserService appUserService) {this.appUserService = appUserService;}

    @PostMapping
    public void addNewAppUser(@RequestBody AppUser user) {
        appUserService.signUpUser(user);
    }
    @DeleteMapping(path = "{id}")
    public void deleteUser(@PathVariable("id") Long id) {appUserService.deleteAppUser(id);}
    @GetMapping
    public List<AppUser> getAppUser() {
        return appUserService.getAppUsers();
    }

    @PutMapping(path = "{id}")
    public void updateUser(@PathVariable("id") Long id, @RequestParam(required = false) String username,String password) {
        appUserService.updateUser(id,username,password);
    }
}
