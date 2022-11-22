package bridge.domain;

import bridge.constant.BridgeProperties;
import bridge.constant.ErrorMessage;

public class BridgeLength {
    private int length;

    public BridgeLength (int length) {
        validate(length);
        this.length = length;
    }

    private void validate (int length) {
        if (!isCorrectRange(length)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_BRIDGE_LENGTH.get());
        }
    }

    private boolean isCorrectRange(int length) {
        return length >= BridgeProperties.MIN_LENGTH.get() && length <= BridgeProperties.MAX_LENGTH.get();
    }

    public int get() {
        return length;
    }
}
