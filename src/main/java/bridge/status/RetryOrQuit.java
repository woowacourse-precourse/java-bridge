package bridge.status;

public enum RetryOrQuit {
    RETRY("R"),
    QUIT("Q");

    private final String message;

    RetryOrQuit(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
