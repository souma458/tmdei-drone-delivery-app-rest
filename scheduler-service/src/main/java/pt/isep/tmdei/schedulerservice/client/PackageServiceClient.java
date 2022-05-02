package pt.isep.tmdei.schedulerservice.client;

import org.springframework.http.ResponseEntity;

public interface PackageServiceClient {

    public ResponseEntity<Void> createPackage(final int weight, final int height, final int width,
            final String delivery);

}
