package bridge.domain;

public enum MovingResult {
    SUCCESS("O"),
    FAIL("X");

    private final String message;

    MovingResult(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }

    public boolean isFail() {
        return this.equals(FAIL);
    }
}
