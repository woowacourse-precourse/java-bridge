package bridge.command;

import bridge.logger.Logger;
import bridge.range.Range;

public class BridgeSize {

    private static final int START_INCLUSIVE = 3;
    private static final int END_INCLUSIVE = 20;

    private static final Range BRIDGE_RANGE = Range.between(START_INCLUSIVE, END_INCLUSIVE);

    private final int value;

    private BridgeSize(final int value) {
        this.value = value;
    }

    public static BridgeSize of(final int value) {
        if (BRIDGE_RANGE.contains(value)) {
            return new BridgeSize(value);
        }
        Logger.error("invalid size of bridge", value);
        throw new IllegalArgumentException();
    }

    public int getValue() {
        return value;
    }
}
