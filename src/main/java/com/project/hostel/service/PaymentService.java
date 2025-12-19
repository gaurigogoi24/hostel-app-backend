package com.project.hostel.service;

import com.project.hostel.entity.Payment;
import com.project.hostel.entity.Student;
import com.project.hostel.repository.PaymentRepository;
import com.project.hostel.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final PaymentRepository repo;
    private final StudentRepository studentRepo;

    public Payment submit(Long studentId, Double amount, String utr, String txnId, String date, String time) {
        Student s = studentRepo.findById(studentId).orElseThrow();

        Payment p = Payment.builder()
                .student(s)
                .amount(amount)
                .utr(utr)
                .txnId(txnId)
                .date(LocalDate.parse(date))
                .time(time)
                .status(Payment.Status.PENDING)
                .build();

        return repo.save(p);
    }
}
