package toy.hong.openapi.app.exception;

public class RequestParamValidationException extends RuntimeException {
    public RequestParamValidationException(String message) {
        super(message);
    }
}
