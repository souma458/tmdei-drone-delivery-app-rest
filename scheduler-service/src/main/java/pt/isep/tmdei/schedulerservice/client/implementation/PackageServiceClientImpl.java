package pt.isep.tmdei.schedulerservice.client.implementation;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import pt.isep.tmdei.schedulerservice.client.PackageServiceClient;

public class PackageServiceClientImpl extends ServiceClient implements PackageServiceClient {

    private RestTemplate restTemplate;

    public PackageServiceClientImpl(String url, String prefix) {
        super(url, prefix);
        restTemplate = new RestTemplate();
    }

    @Override
    public ResponseEntity<Void> createPackage(int weight, int height, int width, String delivery) {
        // TODO Auto-generated method stub
        return null;
    }

}
