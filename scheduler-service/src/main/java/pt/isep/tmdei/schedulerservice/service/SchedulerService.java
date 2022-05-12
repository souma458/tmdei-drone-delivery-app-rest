package pt.isep.tmdei.schedulerservice.service;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import pt.isep.tmdei.schedulerservice.client.DeliveryServiceClient;
import pt.isep.tmdei.schedulerservice.client.DroneServiceClient;
import pt.isep.tmdei.schedulerservice.client.PackageServiceClient;
import pt.isep.tmdei.schedulerservice.client.UserServiceClient;
import pt.isep.tmdei.schedulerservice.model.data.DeliveryStatus;
import pt.isep.tmdei.schedulerservice.model.request.ScheduleDeliveryRequestDTO;
import pt.isep.tmdei.schedulerservice.model.response.GetEtaForDeliveryResponseDTO;
import pt.isep.tmdei.schedulerservice.model.response.PickupPackageResponseDTO;
import pt.isep.tmdei.schedulerservice.model.response.ScheduleDeliveryResponseDTO;
import pt.isep.tmdei.schedulerservice.service.exception.EtaNotObtainableException;

@Service
@RequiredArgsConstructor
public class SchedulerService {

    private final UserServiceClient accountServiceClient;
    private final DeliveryServiceClient deliveryServiceClient;
    private final PackageServiceClient packageServiceClient;
    private final TransportationService transportationService;
    private final DroneServiceClient droneServiceClient;

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

    public PickupPackageResponseDTO pickupPackage(String drone) {
        return deliveryServiceClient.pickupPackage(drone).getBody();
    }

    public void completeDelivery(String delivery) {
        deliveryServiceClient.completeDelivery(delivery);
        var getDeliveryResponse = deliveryServiceClient.getDelivery(delivery).getBody();
        droneServiceClient.idleDrone(getDeliveryResponse.getDrone());
    }

    public void cancelDelivery(String delivery) {
        deliveryServiceClient.cancelDelivery(delivery);
        var getDeliveryResponse = deliveryServiceClient.getDelivery(delivery).getBody();
        droneServiceClient.idleDrone(getDeliveryResponse.getDrone());
    }

    public GetEtaForDeliveryResponseDTO getEtaForDelivery(String delivery) {
        var getDeliveryResponse = deliveryServiceClient.getDelivery(delivery).getBody();
        if (getDeliveryResponse.getStatus().equals(DeliveryStatus.CANCELED.name())) {
            throw new EtaNotObtainableException("Impossible to get an ETA since the delivery has been canceled");
        }
        if (getDeliveryResponse.getStatus().equals(DeliveryStatus.COMPLETED.name())) {
            throw new EtaNotObtainableException("Impossible to get an ETA since the delivery is already completed");
        }
        var response = new GetEtaForDeliveryResponseDTO();
        response.setMinutes(transportationService.calculateEta(getDeliveryResponse));
        return response;
    }

}
