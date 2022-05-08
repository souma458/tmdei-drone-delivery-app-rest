package pt.isep.tmdei.schedulerservice.model.request;

import lombok.Data;

@Data
public class UpdateTransportOfDeliveryRequestDTO {

    private Long drone;
    private String transportationRequest;

}
