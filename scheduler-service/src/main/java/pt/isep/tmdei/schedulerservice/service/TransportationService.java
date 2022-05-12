package pt.isep.tmdei.schedulerservice.service;

import java.util.Random;

import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import lombok.RequiredArgsConstructor;
import pt.isep.tmdei.schedulerservice.client.DeliveryServiceClient;
import pt.isep.tmdei.schedulerservice.client.DroneServiceClient;
import pt.isep.tmdei.schedulerservice.client.ThirdPartyTransportationServiceClient;
import pt.isep.tmdei.schedulerservice.model.response.GetDeliveryResponseDTO;
import pt.isep.tmdei.schedulerservice.model.response.TransportationDTO;

@Service
@RequiredArgsConstructor
public class TransportationService {

    private final DroneServiceClient droneServiceClient;
    private final DeliveryServiceClient deliveryServiceClient;
    private final ThirdPartyTransportationServiceClient thirdPartyTransportationServiceClient;

    private static final int LOW_ESTIMATE = 120;
    private static final int HIGH_ESTIMATE = 1440;

    public TransportationDTO scheduleDeliveryTransport(final String deliveryId) {
        var transportation = new TransportationDTO();

        try {
            var bookDroneResponse = droneServiceClient.bookDrone();
            transportation.setDroneId(bookDroneResponse.getBody().getDroneId());
            deliveryServiceClient.updateDeliveryDrone(deliveryId, bookDroneResponse.getBody().getDroneId());
        } catch (HttpClientErrorException.NotFound notFoundClientException) {
            var createTransportationRequestResponse = thirdPartyTransportationServiceClient
                    .createThirdPartyTransportationRequest(deliveryId);
            transportation.setTransportationRequestId(createTransportationRequestResponse.getBody().getRequestId());
        }

        return transportation;
    }

    public int calculateEta(GetDeliveryResponseDTO getDeliveryResponse) {
        // random value is returned to simulate that an ETA is calculated
        Random random = new Random();
        return random.nextInt(HIGH_ESTIMATE - LOW_ESTIMATE) + LOW_ESTIMATE;
    }

}
