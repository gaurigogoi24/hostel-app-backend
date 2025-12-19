package com.project.hostel.service;


import com.project.hostel.entity.*;
import com.project.hostel.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;
    private final HostelRepository hostelRepository;
    private final RoomApplicationRepository appRepository;
    private final PaymentRepository paymentRepository;
    private final ComplaintRepository complaintRepository;


    public RoomApplication applyForRoom(Long studentId, Long hostelId) {

        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        Hostel hostel = hostelRepository.findById(hostelId)
                .orElseThrow(() -> new RuntimeException("Hostel not found"));

        RoomApplication app = new RoomApplication();
        app.setStudent(student);
        app.setHostel(hostel);
        app.setStatus(RoomApplication.Status.PENDING);

        return appRepository.save(app);
    }


    public Payment submitPayment(Payment payment) {
        // Payment contains student object inside JSON
        return paymentRepository.save(payment);
    }


    public Complaint submitComplaint(Complaint complaint) {
        // Complaint contains student object inside JSON
        complaint.setStatus(Complaint.Status.OPEN);
        return complaintRepository.save(complaint);
    }


    public List<Complaint> getComplaints(Long studentId) {
        return complaintRepository.findByStudentStudentId(studentId);
    }
}

