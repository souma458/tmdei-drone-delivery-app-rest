package pt.isep.tmdei.dronemanagement.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import lombok.RequiredArgsConstructor;
import pt.isep.tmdei.dronemanagement.model.response.BookDroneResponseDTO;
import pt.isep.tmdei.dronemanagement.service.DroneService;

@Controller
@RequiredArgsConstructor
public class DroneController {

    private final DroneService service;

    @PutMapping("/drone/book-available")
    public ResponseEntity<BookDroneResponseDTO> bookAvailableDrone() {
        return new ResponseEntity<BookDroneResponseDTO>(service.bookAvailableDrone(), HttpStatus.OK);
    }

    @PutMapping("/drone/{drone}/idle")
    public ResponseEntity<Void> idleDrone(@PathVariable(value = "drone") Long drone) {
        service.idleDrone(drone);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

}
