package com.project.hostel.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.*;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class Complaint {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long complaintId;

    @ManyToOne
    private Student student;

    private String title;
    private String description;

    @Enumerated(EnumType.STRING)
    private Status status;

    public enum Status { OPEN, IN_PROGRESS, RESOLVED }

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
