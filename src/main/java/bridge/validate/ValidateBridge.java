package bridge.validate;


import static bridge.constants.CommandConstants.*;
import static bridge.constants.ExceptionConstants.*;

public class ValidateBridge {
    private static final int MIN_SIZE = 3;
    private static final int MAX_SIZE = 20;

    public static int validateBridgeSize(String beforeValidateSize) {
        int size = validateBridgeInteger(beforeValidateSize);
        size = validateBridgeSizeInRange(size);
        return size;
    }

    public static int validateBridgeSizeInRange(int size) {
        if (size < MIN_SIZE || size > MAX_SIZE) {
            throw new IllegalArgumentException(BRIDGE_SIZE_OUT_OF_RANGE.getMessage());
        }
        return size;
    }

    public static int validateBridgeInteger(String beforeValidateSize) {
        try {
            int size = Integer.parseInt(beforeValidateSize);
            return size;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(BRIDGE_SIZE_NOT_INTEGER.getMessage());
        }
    }

    public static String validateMovement(String beforeMovement) {
        if (!beforeMovement.equals(MOVE_U.getCommand()) && !beforeMovement.equals(MOVE_D.getCommand())) {
            throw new IllegalArgumentException(MOVE_COMMAND_NOT_U_OR_D.getMessage());
        }
        return beforeMovement;
    }

    public static String validateRetry(String beforeValidateRetry) {
        if (!beforeValidateRetry.equals(RETRY_Q.getCommand()) && !beforeValidateRetry.equals(RETRY_R.getCommand())) {
            throw new IllegalArgumentException(RETRY_COMMAND_NOT_R_OR_Q.getMessage());
        }
        return beforeValidateRetry;
    }
}
