package bridge.domain;

public enum MoveResult {
    SUCCESS("O"),
    FAIL("X");

    private final String initialLetter;

    MoveResult(String initialLetter) {
        this.initialLetter = initialLetter;
    }

    public String getInitialLetter() {
        return initialLetter;
    }

    public boolean isFail() {
        return this.equals(FAIL);
    }
}
