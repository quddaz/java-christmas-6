package christmas.exception;

public class CustomException extends IllegalArgumentException {

    public CustomException(ExceptionMessage message) {
        super(message.message());
    }

}