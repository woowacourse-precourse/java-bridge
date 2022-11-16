package bridge.domain;

public enum MoveStatus {
    SUCCESS("O"),
    FAIL("X");

    private final String initialLetter;

    MoveStatus(String initialLetter) {
        this.initialLetter = initialLetter;
    }
}
