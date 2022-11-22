package bridge.enums;

public enum Retry {
    RETRY("R"), QUIT("Q");

    private String message;

    Retry(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
