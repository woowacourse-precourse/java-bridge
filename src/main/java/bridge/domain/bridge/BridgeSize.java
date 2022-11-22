package bridge.domain.bridge;

import bridge.exception.BridgeError;

public class BridgeSize {

    private static final int MIN_BRIDGE_SIZE = 3;
    private static final int MAX_BRIDGE_SIZE = 20;

    private final int size;

    public BridgeSize(int size) {
        validateSize(size);
        this.size = size;
    }

    private void validateSize(int size) {
        if (size < MIN_BRIDGE_SIZE || size > MAX_BRIDGE_SIZE) {
            throw new IllegalArgumentException(BridgeError.BRIDGE_LENGTH.message());
        }
    }

    public int get() {
        return size;
    }
}

