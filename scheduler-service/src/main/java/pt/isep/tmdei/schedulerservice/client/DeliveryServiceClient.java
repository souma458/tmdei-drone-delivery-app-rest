package pt.isep.tmdei.schedulerservice.client;

import org.springframework.http.ResponseEntity;

import pt.isep.tmdei.schedulerservice.model.data.CoordinatesDTO;
import pt.isep.tmdei.schedulerservice.model.response.CreateDeliveryResponseDTO;

public interface DeliveryServiceClient {

    public ResponseEntity<CreateDeliveryResponseDTO> createDelivery(final String username,
            final CoordinatesDTO pickupCoordinates, final CoordinatesDTO dropOffCoordinates);

}
