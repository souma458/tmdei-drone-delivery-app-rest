package pt.isep.tmdei.usermanagement.model.response;

import lombok.Data;
import pt.isep.tmdei.usermanagement.model.UserAccount;

@Data
public class GetAccountResponseDTO {

    private String username;
    private String status;

    public GetAccountResponseDTO(UserAccount account) {
        this.username = account.getUsername();
        this.status = account.getStatus().name();
    }

}
