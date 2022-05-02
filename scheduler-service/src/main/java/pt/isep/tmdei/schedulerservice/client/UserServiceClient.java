package pt.isep.tmdei.schedulerservice.client;

import org.springframework.http.ResponseEntity;

import pt.isep.tmdei.schedulerservice.model.response.GetAccountResponseDTO;

public interface UserServiceClient {

    public ResponseEntity<GetAccountResponseDTO> getAccount(final String username);

}
