package bridge;

public enum BridgeInfo {
    CORRECT("O"),
    WRONG("X"),
    EMPTY(" ");

    private final String mark;

    BridgeInfo(String mark) {
        this.mark = mark;
    }
}
