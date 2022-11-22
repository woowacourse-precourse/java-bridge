package bridge.dto.output;

public class PrintExceptionDto {

    private final String message;

    public PrintExceptionDto(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
