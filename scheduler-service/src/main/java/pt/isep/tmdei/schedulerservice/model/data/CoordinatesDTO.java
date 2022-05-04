package pt.isep.tmdei.schedulerservice.model.data;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class CoordinatesDTO {

    private BigDecimal latitude;
    private BigDecimal longitude;

}
