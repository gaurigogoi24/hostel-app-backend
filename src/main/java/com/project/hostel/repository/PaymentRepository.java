package com.project.hostel.repository;

import com.project.hostel.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long>
{
}
