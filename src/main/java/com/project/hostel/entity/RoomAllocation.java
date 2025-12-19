package com.project.hostel.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.*;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class RoomAllocation {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long allocationId;

    @ManyToOne
    private Student student;

    @ManyToOne
    private Room room;

    private LocalDateTime allocatedAt;
    private LocalDateTime vacatedAt;
    private Boolean active;
}
