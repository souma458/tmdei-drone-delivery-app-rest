package pt.isep.tmdei.schedulerservice.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import pt.isep.tmdei.schedulerservice.client.UserServiceClient;
import pt.isep.tmdei.schedulerservice.client.DeliveryServiceClient;
import pt.isep.tmdei.schedulerservice.client.PackageServiceClient;
import pt.isep.tmdei.schedulerservice.model.request.ScheduleDeliveryRequestDTO;
import pt.isep.tmdei.schedulerservice.model.response.ScheduleDeliveryResponseDTO;
import pt.isep.tmdei.schedulerservice.service.exception.InvalidAccountException;

@Service
@RequiredArgsConstructor
public class SchedulerService {

    private final UserServiceClient accountServiceClient;
    private final DeliveryServiceClient deliveryServiceClient;
    private final PackageServiceClient packageServiceClient;

    public ScheduleDeliveryResponseDTO scheduleDelivery(ScheduleDeliveryRequestDTO request) {

        // 1 - validate account existence
        var accountServiceResponse = accountServiceClient.getAccount(request.getUsername());

        // 2 - create delivery (STATUS = created)
        // var createDeliveryResponse =
        // deliveryServiceClient.createDelivery(request.getUsername(),
        // request.getPickupCoordinates(), request.getDropOffCoordinates());

        // 3 - create package
        // packageServiceClient.createPackage(request.getWeight(), request.getHeight(),
        // request.getWidth(),
        // createDeliveryResponse.getBody().getDeliveryId());

        // 4 - select drone for delivery

        // 5 - create transportation request if no drone is available

        var response = new ScheduleDeliveryResponseDTO();

        return response;
    }

}
