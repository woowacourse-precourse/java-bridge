package bridge;

import java.util.Arrays;
import java.util.List;

public class Validation {

    private static final int BRIDGE_MIN_SIZE = 3;
    private static final int BRIDGE_MAX_SIZE = 20;
    private static final int MOVING_SIZE = 1;
    private static final List<String> MOVING_VALUES = Arrays.asList("U", "D");

    public static void validateBridgeSize(int size) {
        if (size < BRIDGE_MIN_SIZE || size > BRIDGE_MAX_SIZE) {
            throw new IllegalArgumentException(Error.BRIDGE_OUT_OF_RANGE.getMessage());
        }
    }

    public static void validateMoving(String moving) {
        int isContains = MOVING_VALUES.indexOf(moving);
        if (moving.length() > MOVING_SIZE || isContains == -1) {
            throw new IllegalArgumentException(Error.INVALID_MOVING.getMessage());
        }
    }
}
