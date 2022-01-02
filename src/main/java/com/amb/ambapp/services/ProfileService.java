package com.amb.ambapp.services;

import com.amb.ambapp.modules.Profile;
import com.amb.ambapp.repositories.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Service
public class ProfileService {
    private ProfileRepository profileRepository;

    @Autowired
    public ProfileService(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    public List<Profile> getProfiles() {
        return profileRepository.findAll();
    }
    public void addNewProfile(Profile profile) {
        profileRepository.save(profile);
    }

    public void deleteProfile(int Id) {
        Boolean ProfileExists = profileRepository.existsById(Id);
        if (!ProfileExists) {
            throw new IllegalStateException("Profile with Id:" + Id + " does not exists");
        }
        profileRepository.deleteById(Id);
    }

    @Transactional
    public void updateProfile(int id, String email, String fName, String lName, Date dob) {
        Profile profile = profileRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Profile with Id " + id + " does not exists"));
        if (email != null && !email.isEmpty() && !profile.getEmail().equals(email)) {
            profile.setEmail(email);
        }
        if (fName != null && !fName.isEmpty() && !profile.getFName().equals(fName)) {
            profile.setFName(fName);
        }
        if (lName != null && !lName.isEmpty() && !profile.getLName().equals(lName)) {
            profile.setLName(lName);
        }
        if (dob != null  && !profile.getDOB().equals(dob)) {
            profile.setDOB(dob);
        }



    }


}
