package com.project.hostel.controller;

import com.project.hostel.entity.Complaint;
import com.project.hostel.entity.Hostel;
import com.project.hostel.entity.Room;
import com.project.hostel.entity.RoomApplication;
import com.project.hostel.service.ComplaintService;
import com.project.hostel.service.HostelService;
import com.project.hostel.service.RoomApplicationService;
import com.project.hostel.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class AdminController {

    private final RoomApplicationService appService;
    private final ComplaintService complaintService;
    private final HostelService hostelService;
    private final RoomService roomService;

    // -------------------------------
    // 1. GET ALL HOSTELS
    // -------------------------------
    @GetMapping("/hostels")
    public List<Hostel> getHostels() {
        return hostelService.getAllHostels();
    }

    // -------------------------------
    // 2. ADD HOSTEL
    // -------------------------------
    @PostMapping("/hostels")
    public Hostel addHostel(@RequestBody Hostel hostel) {
        return hostelService.addHostel(hostel);
    }

    // -------------------------------
    // 3. GET ALL ROOMS
    // -------------------------------
    @GetMapping("/rooms")
    public List<Room> getRooms() {
        return roomService.getAllRooms();
    }

    // -------------------------------
    // 4. ADD ROOM
    // -------------------------------
    @PostMapping("/rooms")
    public Room addRoom(@RequestBody Room room) {
        return roomService.addRoom(room);
    }

    // -------------------------------
    // 5. GET ALL ROOM APPLICATIONS
    // -------------------------------
    @GetMapping("/applications")
    public List<RoomApplication> getApplications() {
        return appService.getAllApplications();
    }

    // -------------------------------
    // 6. APPROVE APPLICATION
    // -------------------------------
    @PutMapping("/application/{id}/approve")
    public RoomApplication approve(@PathVariable Long id, @RequestParam Long roomId) {
        return appService.approve(id, roomId);
    }

    // -------------------------------
    // 7. REJECT APPLICATION
    // -------------------------------
    @PutMapping("/application/{id}/reject")
    public RoomApplication reject(@PathVariable Long id) {
        return appService.reject(id);
    }

    // -------------------------------
    // 8. UPDATE COMPLAINT STATUS
    // -------------------------------
    @PutMapping("/complaint/{id}")
    public Complaint updateComplaint(@PathVariable Long id, @RequestParam Complaint.Status status) {
        return complaintService.updateStatus(id, status);
    }
}
