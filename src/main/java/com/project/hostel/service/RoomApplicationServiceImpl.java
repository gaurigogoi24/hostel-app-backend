package com.project.hostel.service;

import com.project.hostel.entity.Hostel;
import com.project.hostel.entity.Room;
import com.project.hostel.entity.RoomApplication;
import com.project.hostel.entity.Student;
import com.project.hostel.repository.HostelRepository;
import com.project.hostel.repository.RoomApplicationRepository;
import com.project.hostel.repository.RoomRepository;
import com.project.hostel.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RoomApplicationServiceImpl implements RoomApplicationService {

    private final RoomApplicationRepository repo;
    private final StudentRepository studentRepo;
    private final HostelRepository hostelRepo;
    private final RoomRepository roomRepo;

    @Override
    public RoomApplication apply(Long studentId, Long hostelId) {
        Student s = studentRepo.findById(studentId).orElseThrow();
        Hostel h = hostelRepo.findById(hostelId).orElseThrow();

        RoomApplication app = RoomApplication.builder()
                .student(s)
                .hostel(h)
                .status(RoomApplication.Status.PENDING)
                .createdAt(LocalDateTime.now())
                .build();

        return repo.save(app);
    }

    @Override
    public List<RoomApplication> getAllApplications() {
        return repo.findAll();
    }

    @Override
    public RoomApplication approve(Long applicationId, Long roomId) {
        RoomApplication app = repo.findById(applicationId).orElseThrow();
        Room room = roomRepo.findById(roomId).orElseThrow();

        if (room.getOccupied() >= room.getCapacity())
            throw new RuntimeException("Room full");

        room.setOccupied(room.getOccupied() + 1);
        roomRepo.save(room);

        app.setRoom(room);
        app.setStatus(RoomApplication.Status.APPROVED);
        app.setUpdatedAt(LocalDateTime.now());

        return repo.save(app);
    }

    @Override
    public RoomApplication reject(Long applicationId) {
        RoomApplication app = repo.findById(applicationId).orElseThrow();
        app.setStatus(RoomApplication.Status.REJECTED);
        app.setUpdatedAt(LocalDateTime.now());
        return repo.save(app);
    }
}
