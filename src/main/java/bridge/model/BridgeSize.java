package bridge.model;

import static bridge.exception.ExceptionMessages.InvalidBridgeSize;

public class BridgeSize {

    private static final int MIN_LENGTH = 3;
    private static final int MAX_LENGTH = 20;

    private final int size;

    public BridgeSize(int size) {
        validateSize(size);
        this.size = size;
    }

    private void validateSize(int size) {
        if(size < MIN_LENGTH || size > MAX_LENGTH) {
            throw new IllegalArgumentException(InvalidBridgeSize);
        }
    }

    public int intValue() {
        return size;
    }
}
