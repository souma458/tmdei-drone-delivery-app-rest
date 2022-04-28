package pt.isep.tmdei.dronemanagement.service;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import pt.isep.tmdei.dronemanagement.repository.DroneRepository;

@Service
@RequiredArgsConstructor
public class DroneService {

    private final DroneRepository droneRepository;

}
