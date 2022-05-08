package pt.isep.tmdei.schedulerservice.service.exception;

public class InvalidAccountException extends RuntimeException {

    public InvalidAccountException(final String message) {
        super(message);
    }

}
