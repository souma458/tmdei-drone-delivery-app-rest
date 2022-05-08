package pt.isep.tmdei.schedulerservice.client;

import org.springframework.http.ResponseEntity;

import pt.isep.tmdei.schedulerservice.model.response.CreateThirdPartyTransportationResponseDTO;

public interface ThirdPartyTransportationServiceClient {

    ResponseEntity<CreateThirdPartyTransportationResponseDTO> createThirdPartyTransportationRequest(String delivery);

}
