package pt.isep.tmdei.schedulerservice.model.response;

import java.util.Date;

import lombok.Data;

@Data
public class ScheduleDeliveryResponseDTO {

    private String username;
    private String deliveryId;
    private String packageId;
    private String status;
    private Date creationDate;
    private Long droneId;
    private String thirdPartyTransportationId;

}
