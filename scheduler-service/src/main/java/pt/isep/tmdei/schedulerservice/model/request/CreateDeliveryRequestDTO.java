package pt.isep.tmdei.schedulerservice.model.request;

import lombok.Data;
import pt.isep.tmdei.schedulerservice.model.data.CoordinatesDTO;

@Data
public class CreateDeliveryRequestDTO {

    private String username;
    private CoordinatesDTO pickupCoordinates;
    private CoordinatesDTO dropOffCoordinates;

}
