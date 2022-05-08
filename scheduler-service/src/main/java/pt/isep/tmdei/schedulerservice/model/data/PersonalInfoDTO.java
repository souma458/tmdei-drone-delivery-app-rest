package pt.isep.tmdei.schedulerservice.model.data;

import java.util.Date;

import lombok.Data;

@Data
public class PersonalInfoDTO {

    private String firstName;
    private String lastName;
    private Date birthDate;
    private String email;
    private String phoneNumber;
    private String address;

}
