package bridge.dto.output;

public class PrintExceptionDto {

    private final String message;

    public PrintExceptionDto(Exception e) {
        this.message = e.getMessage();
    }

    public String getMessage() {
        return message;
    }
}
