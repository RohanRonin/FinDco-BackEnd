package com.example.demo.controller;

import java.util.List;


import com.example.demo.dto.AuthenticationDTO;
import com.example.demo.service.service;
import com.example.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class UserController {
    @Autowired
    service s;
    @GetMapping("/getUser")
    public List<User> getUserDetails() {
        return s.getAllDetails();
    }
    @PostMapping("/saveUser")
    public User postUserDetails(@RequestBody AuthenticationDTO Auth){
        return s.postAllDetails(Auth);
    }
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody AuthenticationDTO Auth) {
        User existingUser = s.findByEmail(Auth.getEmail());
        if (existingUser != null && existingUser.getPassword().equals(Auth.getPassword())) {
            return new ResponseEntity<>("Login Successful", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Invalid Username or Password", HttpStatus.UNAUTHORIZED);
        }
    }
}