package com.project.hostel.controller;

import com.project.hostel.entity.User;
import com.project.hostel.service.AuthService;
import com.project.hostel.service.RegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class AuthController {

    private final AuthService service;

    @PostMapping("/register")
    public User register(@RequestBody RegisterRequest user) {
        return service.register(user);
    }

    @PostMapping("/login")
    public User login(@RequestBody Map<String, String> body) {
        return service.login(body.get("email"), body.get("password"));
    }
}
