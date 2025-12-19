package com.project.hostel.repository;

import com.project.hostel.entity.RoomAllocation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomAllocationRepository extends JpaRepository<RoomAllocation, Long> {
}
