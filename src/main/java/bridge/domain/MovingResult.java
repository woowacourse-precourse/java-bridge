package bridge.domain;

public enum MovingResult {
    SUCCESS("O"),
    FAIL("X");

    private final String message;

    MovingResult(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
