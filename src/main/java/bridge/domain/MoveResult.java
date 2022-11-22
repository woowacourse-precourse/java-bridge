package bridge.domain;

public enum MoveResult {
    SUCCESS("O"),
    FAIL("X");

    private final String message;

    MoveResult(String message) {
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
