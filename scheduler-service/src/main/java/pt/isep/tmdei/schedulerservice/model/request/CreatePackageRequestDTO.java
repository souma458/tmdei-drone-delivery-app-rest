package pt.isep.tmdei.schedulerservice.model.request;

import lombok.Data;

@Data
public class CreatePackageRequestDTO {

    private int weight;
    private int height;
    private int width;
    private String delivery;

}
