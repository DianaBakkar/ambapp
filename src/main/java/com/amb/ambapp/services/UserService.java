package com.amb.ambapp.services;

import com.amb.ambapp.modules.Users;
import com.amb.ambapp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserService {
    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<Users> getUsers() {
        return userRepository.findAll();
    }

    public void addNewUser(Users user) {
        userRepository.save(user);
    }

    public void deleteUser(int Id) {
        Boolean UserExists = userRepository.existsById(Id);
        if (!UserExists) {
            throw new IllegalStateException("User with Id:" + Id + " does not exists");
        }
        userRepository.deleteById(Id);
    }
    @Transactional
    public void updateUser(int id, String username,String password) {
        Users user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("User with Id " + id + " does not exists"));
        if (username != null && !username.isEmpty() && !user.getUsername().equals(username)) {
            user.setUsername(username);
        }
        if (password != null && !password.isEmpty() && !user.getPassword().equals(password)) {
            user.setPassword(password);
        }


        }
        public void updateUserByAdmin(int id,int valid){
            Users user = userRepository.findById(id)
                    .orElseThrow(() -> new IllegalStateException("User with Id " + id + " does not exists"));
            if(valid==0){
                user.setValid(0);
            }
            if(valid==1){
                user.setValid(1);
            }
        }


    }






