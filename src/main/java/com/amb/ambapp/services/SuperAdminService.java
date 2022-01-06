package com.amb.ambapp.services;


import com.amb.ambapp.modules.AppUser;
import com.amb.ambapp.modules.AppUserRole;
import com.amb.ambapp.registration.token.ConfirmationToken;
import com.amb.ambapp.registration.token.ConfirmationTokenService;
import com.amb.ambapp.repositories.AppUserRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;;
import java.util.Optional;
import java.util.UUID;


@Service
@NoArgsConstructor
public class SuperAdminService implements UserDetailsService {
    AppUserRepository appUserRepository;
    ConfirmationTokenService confirmationTokenService;
    BCryptPasswordEncoder bCryptPasswordEncoder;
    private String message="User with email %s not found";

    public SuperAdminService(AppUserRepository appUserRepository, ConfirmationTokenService confirmationTokenService, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.appUserRepository = appUserRepository;
        this.confirmationTokenService = confirmationTokenService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return appUserRepository.findByEmail(email).
                orElseThrow(() -> new UsernameNotFoundException(String.format(message,email)));
    }

    public void addNewAdmin(AppUser user) {
        appUserRepository.save(user);
    }
    public String signUpUser(AppUser appUser) {

        boolean userExists = appUserRepository
                .findByEmail(appUser.getEmail())
                .isPresent();
        if(userExists==true) {
            throw new IllegalStateException("email exists");

        }

        String encodedPassword = bCryptPasswordEncoder.encode(appUser.getPassword());
        appUser.setPassword(encodedPassword);
        appUserRepository.save(appUser);


        String token = UUID.randomUUID().toString();
        ConfirmationToken confirmationToken = new ConfirmationToken(
                token,
                LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(15),
                appUser
        );
        confirmationTokenService.saveConfirmationToken(confirmationToken);
        //TODO:send email
        return token;
    }
    public int enableAppUser(String email) {
        return appUserRepository.enableAppUser(email);
    }



    public void updateAdminBySuper(Long id, String username,String password) {

            AppUser user = appUserRepository.findById(id)
                    .orElseThrow(() -> new IllegalStateException("User with Id " + id + " does not exists"));
            if (username != null && !username.isEmpty() && !user.getLastName().equals(username)) {
                user.setLastName(username);
            }
            if (password != null && !password.isEmpty() && !user.getPassword().equals(password)) {
                user.setPassword(password);
            }


    }
    public void deleteAdminBySuper(Long Id) {
        Boolean UserExists = appUserRepository.existsById(Id);
        if (!UserExists) {
            throw new IllegalStateException("User with Id:" + Id + " does not exists");
        }
        appUserRepository.deleteById(Id);
    }
   /* @Autowired
    public Optional<AppUser> getAdmins() {
        return appUserRepository.findByRole(AppUserRole.ADMIN);
    }
*/
    }