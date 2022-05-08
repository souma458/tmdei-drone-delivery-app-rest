package pt.isep.tmdei.schedulerservice.service;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import pt.isep.tmdei.schedulerservice.client.DeliveryServiceClient;
import pt.isep.tmdei.schedulerservice.client.PackageServiceClient;
import pt.isep.tmdei.schedulerservice.client.UserServiceClient;
import pt.isep.tmdei.schedulerservice.model.request.ScheduleDeliveryRequestDTO;
import pt.isep.tmdei.schedulerservice.model.response.ScheduleDeliveryResponseDTO;

@Service
@RequiredArgsConstructor
public class SchedulerService {

    private final UserServiceClient accountServiceClient;
    private final DeliveryServiceClient deliveryServiceClient;
    private final PackageServiceClient packageServiceClient;
    private final TransportationService transportationService;

    public ScheduleDeliveryResponseDTO scheduleDelivery(ScheduleDeliveryRequestDTO request) {

        accountServiceClient.getAccount(request.getUsername());

        var createDeliveryResponse = deliveryServiceClient
                .createDelivery(request.getUsername(), request.getPickupCoordinates(), request.getDropOffCoordinates())
                .getBody();

        var createPackageResponse = packageServiceClient.createPackage(request.getWeight(), request.getHeight(),
                request.getWidth(), createDeliveryResponse.getDeliveryId()).getBody();

        var transportation = transportationService.scheduleDeliveryTransport(createDeliveryResponse.getDeliveryId());

        var response = new ScheduleDeliveryResponseDTO(request.getUsername(), createDeliveryResponse.getDeliveryId(),
                createPackageResponse.getPackageId(), createDeliveryResponse.getStatus(),
                createDeliveryResponse.getCreated());
        response.setTransportation(transportation);

        return response;
    }

}
