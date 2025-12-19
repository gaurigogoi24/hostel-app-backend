package com.project.hostel.service;

import com.project.hostel.entity.RoomApplication;

import java.util.List;

public interface RoomApplicationService {
    RoomApplication apply(Long studentId, Long hostelId);
    RoomApplication approve(Long applicationId, Long roomId);
    RoomApplication reject(Long applicationId);
    List<RoomApplication> getAllApplications();
}

