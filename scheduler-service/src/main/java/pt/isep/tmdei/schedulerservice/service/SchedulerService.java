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

    public ScheduleDeliveryResponseDTO scheduleDelivery(ScheduleDeliveryRequestDTO request) {

        accountServiceClient.getAccount(request.getUsername());

        var createDeliveryResponse = deliveryServiceClient.createDelivery(request.getUsername(),
                request.getPickupCoordinates(), request.getDropOffCoordinates());

        // 3 - create package
        var createPackageResponse = packageServiceClient.createPackage(request.getWeight(), request.getHeight(),
                request.getWidth(), createDeliveryResponse.getBody().getDeliveryId());

        // 4 - select drone for delivery

        // 5 - create transportation request if no drone is available

        var response = new ScheduleDeliveryResponseDTO();
        response.setUsername(request.getUsername());
        response.setDeliveryId(createDeliveryResponse.getBody().getDeliveryId());
        response.setPackageId(createPackageResponse.getBody().getPackageId());
        response.setStatus(createDeliveryResponse.getBody().getStatus());
        response.setCreationDate(createDeliveryResponse.getBody().getCreated());

        return response;
    }

}
