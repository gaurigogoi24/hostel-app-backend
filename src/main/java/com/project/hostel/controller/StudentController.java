package com.project.hostel.controller;

import com.project.hostel.entity.Complaint;
import com.project.hostel.entity.Payment;
import com.project.hostel.entity.RoomApplication;
import com.project.hostel.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class StudentController {

    private final StudentService studentService;

    // 1. Apply for a room
    @PostMapping("/apply")
    public RoomApplication apply(
            @RequestParam Long studentId,
            @RequestParam Long hostelId
    ) {
        return studentService.applyForRoom(studentId, hostelId);
    }

    // 2. Submit payment
    @PostMapping("/payment")
    public Payment submitPayment(@RequestBody Payment payment) {
        return studentService.submitPayment(payment);
    }

    // 3. Submit complaint
    @PostMapping("/complaint")
    public Complaint submitComplaint(@RequestBody Complaint complaint) {
        return studentService.submitComplaint(complaint);
    }

    // 4. Get complaints for student
    @GetMapping("/complaints/{studentId}")
    public List<Complaint> getComplaints(@PathVariable Long studentId) {
        return studentService.getComplaints(studentId);
    }
}
