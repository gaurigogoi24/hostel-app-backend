package com.project.hostel.service;

import com.project.hostel.entity.User;

public interface AuthService {
    User register(RegisterRequest user);
    User login(String email, String password);
}
