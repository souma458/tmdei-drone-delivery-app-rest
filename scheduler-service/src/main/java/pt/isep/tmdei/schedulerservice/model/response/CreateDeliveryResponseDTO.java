package pt.isep.tmdei.schedulerservice.model.response;

import java.util.Date;

import lombok.Data;
import pt.isep.tmdei.schedulerservice.model.data.CoordinatesDTO;

@Data
public class CreateDeliveryResponseDTO {

    private String username;
    private String deliveryId;
    private CoordinatesDTO pickupCoordinates;
    private CoordinatesDTO dropOffCoordinates;
    private Date created;
    private String status;
    private boolean expedited;

}
