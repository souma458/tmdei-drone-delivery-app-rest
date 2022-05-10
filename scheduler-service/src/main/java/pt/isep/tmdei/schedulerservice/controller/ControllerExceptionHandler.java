package pt.isep.tmdei.schedulerservice.controller;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.context.request.WebRequest;

import pt.isep.tmdei.schedulerservice.model.response.ErrorMessage;
import pt.isep.tmdei.schedulerservice.service.exception.InvalidAccountException;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(value = { InvalidAccountException.class })
    public ResponseEntity<ErrorMessage> invalidAccountException(RuntimeException ex, WebRequest request) {
        ErrorMessage message = new ErrorMessage(HttpStatus.UNPROCESSABLE_ENTITY.value(), new Date(), ex.getMessage());
        return new ResponseEntity<ErrorMessage>(message, HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(value = { HttpClientErrorException.NotFound.class })
    public ResponseEntity<ErrorMessage> notFoundException(RuntimeException ex, WebRequest request) {
        ErrorMessage message = new ErrorMessage(HttpStatus.NOT_FOUND.value(), new Date(), ex.getMessage());
        return new ResponseEntity<ErrorMessage>(message, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = { HttpClientErrorException.Conflict.class })
    public ResponseEntity<ErrorMessage> conflictException(RuntimeException ex, WebRequest request) {
        ErrorMessage message = new ErrorMessage(HttpStatus.CONFLICT.value(), new Date(), ex.getMessage());
        return new ResponseEntity<ErrorMessage>(message, HttpStatus.CONFLICT);
    }

}
