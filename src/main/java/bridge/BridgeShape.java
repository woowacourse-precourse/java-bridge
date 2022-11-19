package bridge;

public enum BridgeShape {
    STARTING_POINT("[ "),
    DIVISION(" | "),
    ENDING_POINT(" ]"),
    BLANK(" "),
    ALLOW_MOVE("O"),
    REFUSE_MOVE("X");

    private final String value;

    BridgeShape(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
