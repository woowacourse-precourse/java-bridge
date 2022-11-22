package bridge;

public class Validation {

    private static final int BRIDGE_MIN_SIZE = 3;
    private static final int BRIDGE_MAX_SIZE = 20;

    public static void validateBridgeSize(int size) {
        if (size < BRIDGE_MIN_SIZE || size > BRIDGE_MAX_SIZE) {
            throw new IllegalArgumentException(Error.BRIDGE_OUT_OF_RANGE.getMessage());
        }
    }
}
