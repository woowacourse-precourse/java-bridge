package bridge;

public class Validation {

    public static void validateBridgeSize(int size) {
        if (size < 3 || size > 20) {
            throw new IllegalArgumentException(Error.BRIDGE_OUT_OF_RANGE.getMessage());
        }
    }
}
