package bridge;

public enum RetryOrQuit {
    RETRY("R"),
    QUIT("Q");

    RetryOrQuit(String message) {
        this.message = message;
    }
    private final String message;

    public String getMessage() {
        return message;
    }
}
