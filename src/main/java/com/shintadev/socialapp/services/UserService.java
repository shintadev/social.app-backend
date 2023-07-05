package com.shintadev.socialapp.services;

import com.shintadev.socialapp.models.User;
import com.shintadev.socialapp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public Boolean isExist(String uid) {
        return userRepository.findById(uid).isPresent();
    }

    public User create(User user) {
        return userRepository.save(user);
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public User getById(String uid) {
        return userRepository.findById(uid).orElseThrow();
    }

    public void update(String uid, String name) {
        userRepository.updateUserById(name, uid);
    }

    public void delete(String uid) {
        userRepository.deleteById(uid);
    }

}
