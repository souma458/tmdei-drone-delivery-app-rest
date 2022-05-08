package pt.isep.tmdei.dronemanagement.controller;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import pt.isep.tmdei.dronemanagement.model.response.ErrorMessage;
import pt.isep.tmdei.dronemanagement.service.exception.NoDroneAvailableException;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(value = { NoDroneAvailableException.class })
    public ResponseEntity<ErrorMessage> noDroneAvailableException(RuntimeException ex, WebRequest request) {
        ErrorMessage message = new ErrorMessage(HttpStatus.NOT_FOUND.value(), new Date(), ex.getMessage());
        return new ResponseEntity<ErrorMessage>(message, HttpStatus.NOT_FOUND);
    }

}
