package bridge.domain.game;

public enum CrossResult {
    SUCCESS("O"),
    FAILURE("X"),
    PASS(" ");

    private final String result;

    CrossResult(String result) {
        this.result = result;
    }

    public String toString() {
        return result;
    }
}
