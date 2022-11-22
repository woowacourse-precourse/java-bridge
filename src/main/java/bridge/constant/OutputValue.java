package bridge.constant;

public enum OutputValue {
    RIGHT_BLOCK("O"),
    WRONG_BLOCK("X");

    private final String block;

    OutputValue(String block) {
        this.block = block;
    }

    public String get() {
        return block;
    }
}