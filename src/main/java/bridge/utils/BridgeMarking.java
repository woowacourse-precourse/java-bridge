package bridge.utils;

public enum BridgeMarking {
    STARTING_POINT_MARKING("[ "),
    END_POINT_MARKING(" ]"),
    MIDDLE_POINT_MARKING(" | "),
    MOVING_SUCCESS_MARKING("O"),
    MOVING_FAIL_MARKING("X"),
    NOTHING_MARKING(" ");

    private final String marking;

    BridgeMarking(String marking) {
        this.marking = marking;
    }

    public String mark() {
        return marking;
    }
}
