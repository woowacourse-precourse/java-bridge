package bridge.constant;

import bridge.BridgeGame;

public enum BridgeSize {
    MAX(20),
    MIN(3);

    private final int value;

    BridgeSize(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
