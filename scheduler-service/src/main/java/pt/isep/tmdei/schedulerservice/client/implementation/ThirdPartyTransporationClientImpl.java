package pt.isep.tmdei.schedulerservice.client.implementation;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import pt.isep.tmdei.schedulerservice.client.ThirdPartyTransportationServiceClient;
import pt.isep.tmdei.schedulerservice.model.request.CreateThirdPartyTransportationRequestDTO;
import pt.isep.tmdei.schedulerservice.model.response.CreateThirdPartyTransportationResponseDTO;

public class ThirdPartyTransporationClientImpl extends ServiceClient implements ThirdPartyTransportationServiceClient {

    private RestTemplate restTemplate;

    public ThirdPartyTransporationClientImpl(String url, String prefix) {
        super(url, prefix);
        this.restTemplate = new RestTemplate();
    }

    @Override
    public ResponseEntity<CreateThirdPartyTransportationResponseDTO> createThirdPartyTransportationRequest(
            String delivery) {
        var request = new CreateThirdPartyTransportationRequestDTO();
        request.setDelivery(delivery);
        return restTemplate.postForEntity(this.basePath() + "/transportation-request", request,
                CreateThirdPartyTransportationResponseDTO.class);
    }

}
