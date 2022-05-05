package pt.isep.tmdei.schedulerservice.model.response;

import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ScheduleDeliveryResponseDTO {

    private String username;
    private String deliveryId;
    private String packageId;
    private String status;
    private Date creationDate;
    private TransportationDTO transportation;

    public ScheduleDeliveryResponseDTO(final String username, final String deliveryId, final String packageId,
            final String status, final Date creationDate) {
        this.username = username;
        this.deliveryId = deliveryId;
        this.packageId = packageId;
        this.status = status;
        this.creationDate = creationDate;
    }

}
