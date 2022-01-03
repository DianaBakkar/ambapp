package com.amb.ambapp.services;

import com.amb.ambapp.modules.AppUser;
import com.amb.ambapp.modules.Types;
import com.amb.ambapp.repositories.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
public class AppUserService implements UserDetailsService {

    private AppUserRepository appUserRepository;
    private String message="User with email %s not found";

    public AppUserService(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return appUserRepository.findByEmail(email).
                orElseThrow(() -> new UsernameNotFoundException(String.format(message,email)));
    }

    @Autowired
    public List<AppUser> getAppUsers() {
        return appUserRepository.findAll();
    }

    public void addNewAppUser(AppUser user) {
        appUserRepository.save(user);
    }

    public void deleteAppUser(Long Id) {
        Boolean UserExists = appUserRepository.existsById(Id);
        if (!UserExists) {
            throw new IllegalStateException("User with Id:" + Id + " does not exists");
        }
        appUserRepository.deleteById(Id);
    }
    @Transactional
    public void updateUser(Long id, String username,String password) {
        AppUser user = appUserRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("User with Id " + id + " does not exists"));
        if (username != null && !username.isEmpty() && !user.getUsername().equals(username)) {
            user.setUsername(username);
        }
        if (password != null && !password.isEmpty() && !user.getPassword().equals(password)) {
            user.setPassword(password);
        }


    }
    public void updateAppUserByAdmin(Long id, int valid, Types requester) {
        if (requester.getType() == 1) {
            AppUser user = appUserRepository.findById(id)
                    .orElseThrow(() -> new IllegalStateException("User with Id " + id + " does not exists"));
            if (valid == 0) {
                user.setValid(0);
            }
            if (valid == 1) {
                user.setValid(1);
            }
        }
    }

}
