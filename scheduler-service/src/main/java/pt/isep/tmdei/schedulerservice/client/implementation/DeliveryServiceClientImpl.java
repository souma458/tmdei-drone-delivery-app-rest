package pt.isep.tmdei.schedulerservice.client.implementation;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import pt.isep.tmdei.schedulerservice.client.DeliveryServiceClient;
import pt.isep.tmdei.schedulerservice.model.data.CoordinatesDTO;
import pt.isep.tmdei.schedulerservice.model.request.CreateDeliveryRequestDTO;
import pt.isep.tmdei.schedulerservice.model.request.UpdateTransportOfDeliveryRequestDTO;
import pt.isep.tmdei.schedulerservice.model.response.CreateDeliveryResponseDTO;
import pt.isep.tmdei.schedulerservice.model.response.PickupPackageResponseDTO;

public class DeliveryServiceClientImpl extends ServiceClient implements DeliveryServiceClient {

    private RestTemplate restTemplate;

    public DeliveryServiceClientImpl(String url, String prefix) {
        super(url, prefix);
        this.restTemplate = new RestTemplate(new HttpComponentsClientHttpRequestFactory());
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

    @Override
    public ResponseEntity<Void> updateDeliveryDrone(String deliveryId, Long droneId) {
        var request = new UpdateTransportOfDeliveryRequestDTO();
        request.setDrone(droneId);
        return restTemplate.exchange(this.basePath() + "/delivery/" + deliveryId, HttpMethod.PATCH,
                new HttpEntity<UpdateTransportOfDeliveryRequestDTO>(request), Void.class);
    }

    @Override
    public ResponseEntity<PickupPackageResponseDTO> pickupPackage(String drone) {
        return restTemplate.exchange(this.basePath() + "/delivery/" + drone + "/pickup", HttpMethod.PUT, null,
                PickupPackageResponseDTO.class);
    }

}
