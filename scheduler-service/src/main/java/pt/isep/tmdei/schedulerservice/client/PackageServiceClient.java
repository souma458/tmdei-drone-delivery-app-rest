package pt.isep.tmdei.schedulerservice.client;

import org.springframework.http.ResponseEntity;

import pt.isep.tmdei.schedulerservice.model.response.CreatePackageResponseDTO;

public interface PackageServiceClient {

    public ResponseEntity<CreatePackageResponseDTO> createPackage(final int weight, final int height, final int width,
            final String delivery);

}
