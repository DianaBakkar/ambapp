package com.amb.ambapp.controllers;

import com.amb.ambapp.services.UserService;
import com.amb.ambapp.modules.Users;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/users")
public class MainController {
    private UserService userService;

    public MainController(UserService userService) {this.userService = userService;}

    @PostMapping
    public void registerNewUser(@RequestBody Users user) {
        userService.addNewUser(user);
    }
    @DeleteMapping(path = "{id}")
    public void deleteUser(@PathVariable("id") int id) {userService.deleteUser(id);}
    @GetMapping
    public List<Users> getUsers() {
        return userService.getUsers();
    }

    @PutMapping(path = "{id}")
    public void updateUser(@PathVariable("id") int id, @RequestParam(required = false) String username,String password) {
        userService.updateUser(id,username,password);
    }
}
