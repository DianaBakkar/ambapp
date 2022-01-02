package com.amb.ambapp.controllers;

import com.amb.ambapp.modules.Users;
import com.amb.ambapp.services.ProfileService;
import com.amb.ambapp.modules.Profile;
import com.amb.ambapp.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;


@RestController
@RequestMapping(path = "api/v1/profile")
public class ProfileController {
    private ProfileService profileService;

    public ProfileController(ProfileService profileService) {this.profileService = profileService;}

    @PostMapping
    public void registerNewProfile(@RequestBody Profile profile) {
        profileService.addNewProfile(profile);
    }
    @DeleteMapping(path = "{id}")
    public void deleteProfile(@PathVariable("id") int id) {
        profileService.deleteProfile(id);
    }
    @GetMapping
    public List<Profile> getProfile() {return profileService.getProfiles();}
    @PutMapping(path = "{id}")
    public void updateProfile(@PathVariable("id") int id, @RequestParam(required = false) String email, String fName, String lName, Date dob) {
        profileService.updateProfile(id,email,fName,lName,dob);
    }







}
