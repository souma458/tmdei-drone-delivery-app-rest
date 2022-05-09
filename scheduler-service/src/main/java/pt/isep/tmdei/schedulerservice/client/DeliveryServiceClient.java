package pt.isep.tmdei.schedulerservice.client;

import org.springframework.http.ResponseEntity;

import pt.isep.tmdei.schedulerservice.model.data.CoordinatesDTO;
import pt.isep.tmdei.schedulerservice.model.response.CreateDeliveryResponseDTO;
import pt.isep.tmdei.schedulerservice.model.response.PickupPackageResponseDTO;

public interface DeliveryServiceClient {

    ResponseEntity<CreateDeliveryResponseDTO> createDelivery(final String username,
            final CoordinatesDTO pickupCoordinates, final CoordinatesDTO dropOffCoordinates);

    ResponseEntity<Void> updateDeliveryDrone(final String deliveryId, final Long droneId);

    ResponseEntity<PickupPackageResponseDTO> pickupPackage(String drone);

}
