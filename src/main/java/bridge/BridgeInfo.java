package bridge;

public enum BridgeInfo {
    Correct("O"),
    Wrong("X"),
    Empty(" ");

    private final String mark;

    BridgeInfo(String mark) {
        this.mark = mark;
    }
}
