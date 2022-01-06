/*package com.amb.ambapp.controllers;


import com.amb.ambapp.modules.AppUser;
import com.amb.ambapp.services.SuperAdminService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path="api/v1/Super")
public class SuperController {

    private SuperAdminService superAdminService;
    public SuperController(SuperAdminService superAdminService){this.superAdminService=superAdminService;}

    @PostMapping
    public void addNewAppUser(@RequestBody AppUser user) {
        superAdminService.signUpUser(user);
    }

    @DeleteMapping(path = "{id}")
    public void deleteUser(@PathVariable("id") Long id) {superAdminService.deleteAdminBySuper(id);}

    @GetMapping
    public Optional<AppUser> getAdmins() {
        return superAdminService.getAdmins();
    }

    @PutMapping(path = "{id}")
    public void updateAdminBySuper(@PathVariable("id") Long id, @RequestParam(required = false) String username,String password) {
        superAdminService.updateAdminBySuper(id,username,password);
    }





}
*/