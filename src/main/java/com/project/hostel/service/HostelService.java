package com.project.hostel.service;

import com.project.hostel.entity.Hostel;
import com.project.hostel.repository.HostelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HostelService {

    private final HostelRepository hostelRepository;


    public List<Hostel> getAllHostels() {
        return hostelRepository.findAll();
    }


    public Hostel addHostel(Hostel hostel) {
        return hostelRepository.save(hostel);
    }
}
