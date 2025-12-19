package com.project.hostel.repository;

import com.project.hostel.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Student findByUserUserId(Long userId);
}
