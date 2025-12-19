package com.project.hostel.service;

import com.project.hostel.entity.Complaint;
import com.project.hostel.entity.Student;
import com.project.hostel.repository.ComplaintRepository;
import com.project.hostel.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class ComplaintService {

    private final ComplaintRepository repo;
    private final StudentRepository studentRepo;

    public Complaint submit(Long studentId, String title, String description) {
        Student s = studentRepo.findById(studentId).orElseThrow();

        Complaint c = Complaint.builder()
                .student(s)
                .title(title)
                .description(description)
                .status(Complaint.Status.OPEN)
                .createdAt(LocalDateTime.now())
                .build();

        return repo.save(c);
    }

    public Complaint updateStatus(Long id, Complaint.Status status) {
        Complaint c = repo.findById(id).orElseThrow();
        c.setStatus(status);
        c.setUpdatedAt(LocalDateTime.now());
        return repo.save(c);
    }
}

