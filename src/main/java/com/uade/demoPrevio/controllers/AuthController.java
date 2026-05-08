package com.uade.demoPrevio.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uade.demoPrevio.dto.LoginRequest;
import com.uade.demoPrevio.entity.User;
import com.uade.demoPrevio.repository.UserRepository;
import com.uade.demoPrevio.service.JwtService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepositoritory;
    @Autowired
    private JwtService jwtService;

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest request) {

        Optional<User> optionalUser = userRepositoritory.findByEmail(request.getEmail());
        if (!optionalUser.isPresent())
            throw new RuntimeException("User not found");
        User user = optionalUser.get();
        if (!user.getPassword().equals(request.getPassword()))
            throw new RuntimeException("Passwords do not match");

        return jwtService.generateToken(user.getEmail());
    }

}
