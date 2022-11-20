package bridge.domain;

import static bridge.ui.InputValue.*;
import static bridge.ui.ReservedMessage.*;

public class Validation {
    private static final int SIZE_FLOOR = 3;
    private static final int SIZE_CEILING = 20;

    public static int validateBridgeSize(String size) throws IllegalArgumentException {
        int converted = validateFormatOfSize(size);
        validateRangeOfSize(converted);
        return converted;
    }

    private static int validateFormatOfSize(String size) {
        try {
            return Integer.parseInt(size);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_NUMBER_FORMAT.getMsg());
        }
    }

    private static void validateRangeOfSize(int size) {
        if (size < SIZE_FLOOR || size > SIZE_CEILING) {
            throw new IllegalArgumentException(SIZE_OUT_OF_BOUNDS.getMsg());
        }
    }

    public static void validateSpace(String space) throws IllegalArgumentException {
        if (!space.equals(UP.getValue()) && !space.equals(DOWN.getValue())) {
            throw new IllegalArgumentException(NOT_U_OR_D.getMsg());
        }
    }

    public static void validateResponseAfterFailure(String response) throws IllegalArgumentException {
        if (!response.equals(RESTART.getValue()) && !response.equals(QUIT.getValue())) {
            throw new IllegalArgumentException(NOT_R_OR_Q.getMsg());
        }
    }

}
