package bridge.domain;

public enum MoveResult {
    SUCCESS("O"),
    FAIL("X");

    private final String initialLetter;

    MoveResult(String initialLetter) {
        this.initialLetter = initialLetter;
    }
}
