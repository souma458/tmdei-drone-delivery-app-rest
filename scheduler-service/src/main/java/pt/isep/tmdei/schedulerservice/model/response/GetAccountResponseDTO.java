package pt.isep.tmdei.schedulerservice.model.response;

import lombok.Data;
import pt.isep.tmdei.schedulerservice.model.data.PersonalInfoDTO;

@Data
public class GetAccountResponseDTO {

    private String username;
    private String status;
    private PersonalInfoDTO personalInfo;

}
