package com.telusko.contest.controller;

import com.telusko.contest.entity.Users;
import com.telusko.contest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class RegisterController {

    @Autowired
    private UserRepository userRepo;

    @PostMapping("/register")
    public String registerUser(@RequestBody Users user) {
        userRepo.save(user);
        return "Registration successful!";
    }

}
