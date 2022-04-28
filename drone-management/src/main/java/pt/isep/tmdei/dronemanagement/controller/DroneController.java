package pt.isep.tmdei.dronemanagement.controller;

import org.springframework.stereotype.Controller;

import lombok.RequiredArgsConstructor;
import pt.isep.tmdei.dronemanagement.service.DroneService;

@Controller
@RequiredArgsConstructor
public class DroneController {

    private final DroneService droneService;

}
