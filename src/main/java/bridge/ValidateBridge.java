package bridge;


import static bridge.constants.CommandConstants.*;
import static bridge.constants.ExceptionConstants.*;

public class ValidateBridge {
    private static final int MIN_SIZE = 3;
    private static final int MAX_SIZE = 20;

    static int validateBridgeSize(String beforeValidateSize) {
        int size = 0;
        try {
            size = Integer.parseInt(beforeValidateSize);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(BRIDGE_SIZE_NOT_INTEGER.getMessage());
        }

        if (size < MIN_SIZE || size > MAX_SIZE) {
            throw new IllegalArgumentException(BRIDGE_SIZE_OUT_OF_RANGE.getMessage());
        }
        return size;
    }

    static String validateMovement(String beforeMovement) {
        if (!beforeMovement.equals(MOVE_U.getCommand()) && !beforeMovement.equals(MOVE_D.getCommand())) {
            throw new IllegalArgumentException(MOVE_COMMAND_NOT_U_OR_D.getMessage());
        }
        return beforeMovement;
    }

    static String validateRetry(String beforeValidateRetry) {
        if (!beforeValidateRetry.equals(RETRY_Q.getCommand()) && !beforeValidateRetry.equals(RETRY_R.getCommand())) {
            throw new IllegalArgumentException(RETRY_COMMAND_NOT_R_OR_Q.getMessage());
        }
        return beforeValidateRetry;
    }
}
