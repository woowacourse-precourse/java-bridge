package bridge.domain;

public enum BridgeMap {
    BRIDGE_START_MARK("[ "),
    BRIDGE_END_MARK(" ]"),
    BRIDGE_DIVISION_MARK(" | "),
    SUCCESS_MARK("O"),
    FAIL_MARK("X"),
    BLANK_MARK(" ");

    private final String mark;

    private BridgeMap(String mark) {
        this.mark = mark;
    }

    public String getMark() {
        return this.mark;
    }
}
