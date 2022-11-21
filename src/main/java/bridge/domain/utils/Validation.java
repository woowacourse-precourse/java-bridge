package bridge.domain.utils;

import static bridge.domain.ui.RetryOrQuit.*;
import static bridge.domain.ui.ReservedMessage.*;
import static bridge.domain.utils.Space.*;

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
        if (!space.equals(UP.getRepresented()) && !space.equals(DOWN.getRepresented())) {
            throw new IllegalArgumentException(NOT_U_OR_D.getMsg());
        }
    }

    public static void validateResponseAfterFailure(String response) throws IllegalArgumentException {
        if (!response.equals(RETRY.getValue()) && !response.equals(QUIT.getValue())) {
            throw new IllegalArgumentException(NOT_R_OR_Q.getMsg());
        }
    }

}
