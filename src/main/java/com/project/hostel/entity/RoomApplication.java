package com.project.hostel.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.*;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class RoomApplication {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long applicationId;

    @ManyToOne
    private Student student;

    @ManyToOne
    private Hostel hostel;

    @ManyToOne
    private Room room; // null until approved

    @Enumerated(EnumType.STRING)
    private Status status;

    public enum Status { PENDING, APPROVED, REJECTED }

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
