package bridge.Exception;

public enum ExceptionMessage {
    NOT_NUMBER("[ERROR] 숫자가 아님"),
    NOT_RANGE("[ERROR] 숫자의 범위가 아님");

    private String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
