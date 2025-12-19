package com.project.hostel.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class Room {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roomId;

    @ManyToOne
    private Hostel hostel;

    private String roomNumber;

    @Enumerated(EnumType.STRING)
    private Type type;

    public enum Type { SINGLE, DOUBLE, TRIPLE }

    private Integer capacity;
    private Integer occupied;
    private String status; // AVAILABLE / FULL
}
