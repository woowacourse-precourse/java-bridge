package bridge.model;

import bridge.error.Error;

public class BridgeSize {

    private static final int MIN_SIZE = 3;
    private static final int MAX_SIZE = 20;

    private final int value;

    public BridgeSize(int value) {
        validate(value);

        this.value = value;
    }

    private void validate(int value) {
        if (value < MIN_SIZE || value > MAX_SIZE) {
            throw new IllegalArgumentException(Error.BRIDGE_SIZE_RANGE_ERROR.getMessage());
        }
    }

    public int getValue() {
        return value;
    }
}
