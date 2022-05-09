package pt.isep.tmdei.schedulerservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import lombok.RequiredArgsConstructor;
import pt.isep.tmdei.schedulerservice.model.request.ScheduleDeliveryRequestDTO;
import pt.isep.tmdei.schedulerservice.model.response.PickupPackageResponseDTO;
import pt.isep.tmdei.schedulerservice.model.response.ScheduleDeliveryResponseDTO;
import pt.isep.tmdei.schedulerservice.service.SchedulerService;

@Controller
@RequiredArgsConstructor
public class SchedulerController {

    private final SchedulerService service;

    @PostMapping("/schedule-delivery")
    public ResponseEntity<ScheduleDeliveryResponseDTO> scheduleDelivery(
            @RequestBody ScheduleDeliveryRequestDTO request) {
        return new ResponseEntity<>(service.scheduleDelivery(request), HttpStatus.CREATED);
    }

    @PostMapping("/pickup-delivery/{drone}")
    public ResponseEntity<PickupPackageResponseDTO> pickupPackage(@PathVariable(value = "drone") String drone) {
        return new ResponseEntity<>(service.pickupPackage(drone), HttpStatus.OK);
    }

    @PostMapping("/complete-delivery/{delivery}")
    public ResponseEntity<Void> deliverPackage(@PathVariable(value = "delivery") String delivery) {
        service.deliverPackage(delivery);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
