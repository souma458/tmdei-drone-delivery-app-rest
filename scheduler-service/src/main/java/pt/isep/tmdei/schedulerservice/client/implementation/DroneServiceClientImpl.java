package pt.isep.tmdei.schedulerservice.client.implementation;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import pt.isep.tmdei.schedulerservice.client.DroneServiceClient;
import pt.isep.tmdei.schedulerservice.model.response.BookDroneResponseDTO;

public class DroneServiceClientImpl extends ServiceClient implements DroneServiceClient {

    private RestTemplate restTemplate;

    public DroneServiceClientImpl(String url, String prefix) {
        super(url, prefix);
        restTemplate = new RestTemplate();
    }

    @Override
    public ResponseEntity<BookDroneResponseDTO> bookDrone() {
        return restTemplate.exchange(this.basePath() + "/drone/book-available", HttpMethod.PUT, null,
                BookDroneResponseDTO.class);
    }

}
