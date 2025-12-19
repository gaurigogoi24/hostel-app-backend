package com.project.hostel.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.*;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class Payment {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long paymentId;

    @ManyToOne
    private Student student;

    private Double amount;

    private String utr;
    private String txnId;
    private LocalDate date;
    private String time;

    @Enumerated(EnumType.STRING)
    private Status status;

    public enum Status { PENDING, VERIFIED }
}
