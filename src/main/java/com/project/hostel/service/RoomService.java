package com.project.hostel.service;

import com.project.hostel.entity.Room;
import com.project.hostel.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class  RoomService {

    private final RoomRepository roomRepository;


    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }


    public Room addRoom(Room room) {
        room.setOccupied(0);
        room.setStatus("AVAILABLE");
        room.setType(Room.Type.DOUBLE);
        return roomRepository.save(room);
    }
}

