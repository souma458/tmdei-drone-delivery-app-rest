package pt.isep.tmdei.schedulerservice.client.implementation;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import pt.isep.tmdei.schedulerservice.client.UserServiceClient;
import pt.isep.tmdei.schedulerservice.model.response.GetAccountResponseDTO;
import pt.isep.tmdei.schedulerservice.service.exception.InvalidAccountException;

public class UserServiceClientImpl extends ServiceClient implements UserServiceClient {

    private RestTemplate restTemplate;

    public UserServiceClientImpl(String url, String prefix) {
        super(url, prefix);
        restTemplate = new RestTemplate();
    }

    @Override
    public ResponseEntity<GetAccountResponseDTO> getAccount(String username) {
        try {
            return restTemplate.getForEntity(this.basePath() + "/account/" + username, GetAccountResponseDTO.class);
        } catch (HttpClientErrorException.NotFound exception) {
            throw new InvalidAccountException(exception.getMessage());
        }
    }

}
