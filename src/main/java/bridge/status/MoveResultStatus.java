package bridge.status;

public enum MoveResultStatus {
    CORRECT("O"),
    FAIL("X"),

    NOTHING(" ");

    private String text;

    MoveResultStatus(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
