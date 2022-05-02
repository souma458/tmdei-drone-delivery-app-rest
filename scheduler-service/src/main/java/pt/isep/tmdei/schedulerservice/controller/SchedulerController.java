package pt.isep.tmdei.schedulerservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import lombok.RequiredArgsConstructor;
import pt.isep.tmdei.schedulerservice.model.request.ScheduleDeliveryRequestDTO;
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

}
