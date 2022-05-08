package pt.isep.tmdei.schedulerservice.model.response;

import java.util.Date;

import lombok.Data;

@Data
public class CreateThirdPartyTransportationResponseDTO {

    private String requestId;
    private String status;
    private Date requestDate;

}
