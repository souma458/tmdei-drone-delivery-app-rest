package pt.isep.tmdei.usermanagement.model.response;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorMessage {

    private int status;
    private Date date;
    private String message;

}
