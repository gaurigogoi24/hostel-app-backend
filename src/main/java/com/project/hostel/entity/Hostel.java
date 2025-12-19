package com.project.hostel.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class Hostel {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long hostelId;

    private String name;

    private Integer capacity;
}
