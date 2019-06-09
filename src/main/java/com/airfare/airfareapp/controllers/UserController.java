package com.airfare.airfareapp.controllers;

import com.airfare.airfareapp.domain.User;
import com.airfare.airfareapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping({"/user"})
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping()
    public List<User> findAllUsers(){
        return userRepository.findAll();
    }

    @PostMapping()
    public User saveUser(@RequestBody User u){
        return userRepository.save(u);
    }

    @PutMapping(path = "/{id}")
    public User editUser(@RequestBody User u, @PathVariable("id") int id){
        u.setId(id);
        return userRepository.save(u);
    }

    @GetMapping(path = "/{id}")
    public Optional<User> getUserById (@PathVariable("id") int id){
        return userRepository.findById(id);
    }

}
