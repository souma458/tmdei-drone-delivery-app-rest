package pt.isep.tmdei.schedulerservice.model.request;

import lombok.Data;
import pt.isep.tmdei.schedulerservice.model.data.CoordinatesDTO;

@Data
public class ScheduleDeliveryRequestDTO {

    private String username;
    private CoordinatesDTO pickupCoordinates;
    private CoordinatesDTO dropOffCoordinates;
    private int weight;
    private int width;
    private int height;
    private String sendersRef;

}
