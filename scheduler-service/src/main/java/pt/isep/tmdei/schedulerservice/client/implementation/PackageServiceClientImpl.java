package pt.isep.tmdei.schedulerservice.client.implementation;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import pt.isep.tmdei.schedulerservice.client.PackageServiceClient;
import pt.isep.tmdei.schedulerservice.model.request.CreatePackageRequestDTO;
import pt.isep.tmdei.schedulerservice.model.response.CreatePackageResponseDTO;

public class PackageServiceClientImpl extends ServiceClient implements PackageServiceClient {

    private RestTemplate restTemplate;

    public PackageServiceClientImpl(String url, String prefix) {
        super(url, prefix);
        restTemplate = new RestTemplate();
    }

    @Override
    public ResponseEntity<CreatePackageResponseDTO> createPackage(int weight, int height, int width, String delivery) {
        var request = new CreatePackageRequestDTO();
        request.setWeight(weight);
        request.setHeight(height);
        request.setWidth(width);
        request.setDelivery(delivery);
        return restTemplate.postForEntity(this.basePath() + "/package", request, CreatePackageResponseDTO.class);
    }

}
