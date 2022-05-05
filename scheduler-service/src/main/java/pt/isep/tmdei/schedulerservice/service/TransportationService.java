package pt.isep.tmdei.schedulerservice.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import lombok.RequiredArgsConstructor;
import pt.isep.tmdei.schedulerservice.client.DeliveryServiceClient;
import pt.isep.tmdei.schedulerservice.client.DroneServiceClient;
import pt.isep.tmdei.schedulerservice.client.ThirdPartyTransportationServiceClient;
import pt.isep.tmdei.schedulerservice.model.response.TransportationDTO;

@Service
@RequiredArgsConstructor
public class TransportationService {

    private final DroneServiceClient droneServiceClient;
    private final DeliveryServiceClient deliveryServiceClient;
    // private final ThirdPartyTransportationServiceClient
    // thirdPartyTransportationServiceClient;

    public TransportationDTO scheduleDeliveryTransport(final String deliveryId) {
        var transportation = new TransportationDTO();

        try {
            var bookDroneResponse = droneServiceClient.bookDrone();
            transportation.setDroneId(bookDroneResponse.getBody().getDroneId());
            deliveryServiceClient.updateDeliveryDrone(deliveryId, bookDroneResponse.getBody().getDroneId());
        } catch (HttpClientErrorException.NotFound notFoundClientException) {
            // 5 - create transportation request if no drone is available
        }

        return transportation;
    }

}
