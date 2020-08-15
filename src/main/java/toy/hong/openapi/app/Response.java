package toy.hong.openapi.app;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Response {
    private Object data;
    private int statusCode;
    private String message;

    public Response(int statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }

    public Response(int statusCode, String message, Object data) {
        this.data = data;
        this.statusCode = statusCode;
        this.message = message;
    }
}