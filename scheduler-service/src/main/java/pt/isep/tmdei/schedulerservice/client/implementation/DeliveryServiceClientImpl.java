package pt.isep.tmdei.schedulerservice.client.implementation;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import pt.isep.tmdei.schedulerservice.client.DeliveryServiceClient;
import pt.isep.tmdei.schedulerservice.model.data.CoordinatesDTO;
import pt.isep.tmdei.schedulerservice.model.request.CreateDeliveryRequestDTO;
import pt.isep.tmdei.schedulerservice.model.response.CreateDeliveryResponseDTO;

public class DeliveryServiceClientImpl extends ServiceClient implements DeliveryServiceClient {

    private RestTemplate restTemplate;

    public DeliveryServiceClientImpl(String url, String prefix) {
        super(url, prefix);
        this.restTemplate = new RestTemplate();
    }

    @Override
    public ResponseEntity<CreateDeliveryResponseDTO> createDelivery(String username, CoordinatesDTO pickupCoordinates,
            CoordinatesDTO dropOffCoordinates) {
        var request = new CreateDeliveryRequestDTO();
        request.setUsername(username);
        request.setPickupCoordinates(pickupCoordinates);
        request.setDropOffCoordinates(dropOffCoordinates);
        return restTemplate.postForEntity(this.basePath() + "/delivery", request, CreateDeliveryResponseDTO.class);
    }

}
