package pt.isep.tmdei.usermanagement.controller;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import pt.isep.tmdei.usermanagement.model.response.ErrorMessage;
import pt.isep.tmdei.usermanagement.service.exception.AccountNotFoundException;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(value = { AccountNotFoundException.class })
    public ResponseEntity<ErrorMessage> accountNotFoundException(RuntimeException ex, WebRequest request) {
        ErrorMessage message = new ErrorMessage(HttpStatus.NOT_FOUND.value(), new Date(), ex.getMessage());
        return new ResponseEntity<ErrorMessage>(message, HttpStatus.NOT_FOUND);
    }

}
