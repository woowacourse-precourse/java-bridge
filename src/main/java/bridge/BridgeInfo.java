package bridge;

public enum BridgeInfo {
    CORRECT("O"),
    WRONG("X"),
    EMPTY(" "),
    HEAD("[ "),
    TAIL(" ]"),
    DELIMITER(" | ");

    private final String mark;

    BridgeInfo(String mark) {
        this.mark = mark;
    }

    public String getMart() {
        return mark;
    }
}
