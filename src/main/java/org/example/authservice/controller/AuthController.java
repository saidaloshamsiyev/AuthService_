package org.example.authservice.controller;

import lombok.RequiredArgsConstructor;


import org.example.authservice.domain.request.LoginDTO;
import org.example.authservice.domain.request.UserRequest;
import org.example.authservice.domain.response.JwtResponse;
import org.example.authservice.domain.response.UserResponse;
import org.example.authservice.service.service.user.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;

    @PostMapping("/register")
    public UserResponse register(@RequestBody UserRequest userRequest) {
        return userService.saveUser(userRequest);
    }


    @PostMapping("/login")
    public JwtResponse login(@RequestBody LoginDTO loginDTO) {
        return userService.login(loginDTO);
    }

    @GetMapping("/{id}")
    public UserResponse getUser(@PathVariable UUID id) {
        return userService.findById(id);
    }

}
