package pt.isep.tmdei.schedulerservice.client;

import org.springframework.http.ResponseEntity;

import pt.isep.tmdei.schedulerservice.model.response.BookDroneResponseDTO;

public interface DroneServiceClient {

    ResponseEntity<BookDroneResponseDTO> bookDrone();

    ResponseEntity<Void> idleDrone(String drone);

}
