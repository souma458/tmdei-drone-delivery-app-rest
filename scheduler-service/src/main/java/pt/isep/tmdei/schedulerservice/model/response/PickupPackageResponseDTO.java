package pt.isep.tmdei.schedulerservice.model.response;

import lombok.Data;
import pt.isep.tmdei.schedulerservice.model.data.CoordinatesDTO;

@Data
public class PickupPackageResponseDTO {

    private String delivery;
    private CoordinatesDTO pickup;
    private CoordinatesDTO dropOff;
    private String status;

}
