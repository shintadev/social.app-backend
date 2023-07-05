package com.shintadev.socialapp.controllers;

import com.shintadev.socialapp.models.User;
import com.shintadev.socialapp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    //---------------QUERY---------------
    @QueryMapping
    public List<User> getAllUsers() {
        return userService.getAll();
    }

    @QueryMapping
    public User getUserById(String uid) {
        return userService.getById(uid);
    }

    //---------------MUTATION---------------
    @MutationMapping
    public User createUser(@Argument String id, @Argument String name) {
        User user = new User(id, name);
        return userService.create(user);
    }

    @MutationMapping
    public User updateUser(@Argument String id, @Argument String name) {
        User user = new User(id, name);
        userService.update(id, name);
        return user;
    }

    @MutationMapping
    public User deleteUser(@Argument String id){
        User user = userService.getById(id);
        userService.delete(id);
        return user;
    }

}

