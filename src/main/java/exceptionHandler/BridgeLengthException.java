package exceptionHandler;

import enumCollections.AvailableInput;
import enumCollections.ExceptionMessage;

public class BridgeLengthException {
    private static final String regularExpression = "^[0-9]*$";

    public static void validate(String length) {
        validateNumeric(length);
        validateMinimumRange(stringToInteger(length));
        validateMaximumRange(stringToInteger(length));
    }

    private static void validateNumeric(String length) {
        if (!length.matches(regularExpression)) {
            throw new IllegalArgumentException(ExceptionMessage.getMessage(ExceptionMessage.NOT_NUMERIC));
        }
    }

    private static void validateMinimumRange(int length) {
        if (length < AvailableInput.getBridgeLengthRange(AvailableInput.BRIDGE_MINUMUM_LENGTH)) {
            throw new IllegalArgumentException(
                    ExceptionMessage.getMessage(ExceptionMessage.SMALLER_THAN_MINIMUM_BRIDGE_LENGTH)
            );
        }
    }

    private static void validateMaximumRange(int length) {
        if (length > AvailableInput.getBridgeLengthRange(AvailableInput.BRIDGE_MAXIMUM_LENGTH)) {
            throw new IllegalArgumentException(
                    ExceptionMessage.getMessage(ExceptionMessage.BIGGER_THAN_MAXIMUM_BRIDGE_LENGTH)
            );
        }
    }

    private static int stringToInteger(String input) {
        return Integer.valueOf(input);
    }
}
