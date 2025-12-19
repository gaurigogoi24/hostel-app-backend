package com.project.hostel.service;

import com.project.hostel.entity.Student;
import com.project.hostel.entity.User;
import com.project.hostel.repository.StudentRepository;
import com.project.hostel.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final StudentRepository studentRepository;
    @Override
    public User register(RegisterRequest request) {
        // 1. Create and populate User object
        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPhone(request.getPhone());
        user.setPassword(request.getPassword());
        user.setRole(User.Role.valueOf(request.getRole().toUpperCase()));


        User savedUser = userRepository.save(user);

        // 2. If user is a student, also create student entry
        if (savedUser.getRole() == User.Role.STUDENT) {

            Student student = new Student();
            student.setUser(savedUser);
            student.setRollNo("ROLL" + savedUser.getUserId()); // auto-generated example
            student.setCourse(request.getCourse()); // coming from frontend
            student.setYear(request.getYear());

            studentRepository.save(student);
        }

        return savedUser;
    }

    @Override
    public User login(String email, String password) {

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Invalid email or password"));

        if (!user.getPassword().equals(password)) {
            throw new RuntimeException("Invalid email or password");
        }

        // If student → load studentId and add it to User object
        if (user.getRole() == User.Role.STUDENT) {
            Student student = studentRepository.findByUserUserId(user.getUserId());
            if (student != null) {
                user.setUserId(student.getStudentId());  // SEND THIS TO FRONTEND
            }
        }

        return user;
    }
}
