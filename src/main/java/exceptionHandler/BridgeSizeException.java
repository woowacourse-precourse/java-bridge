package exceptionHandler;

import enumCollections.AvailableInput;
import enumCollections.ExceptionMessage;

public class BridgeSizeException {
    public static void validate(String size) {
        validateNumeric(size);
        validateMinimumRange(stringToInteger(size));
        validateMaximumRange(stringToInteger(size));
    }

    private static void validateNumeric(String size) {
        if (!size.matches(AvailableInput.NUMERIC_RANGE.getUserInput())) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_NUMERIC.getMessage());
        }
    }

    private static void validateMinimumRange(int size) {
        if (size < AvailableInput.getBridgeMinimumSizeValue()) {
            throw new IllegalArgumentException(
                    ExceptionMessage.SMALLER_THAN_MINIMUM_BRIDGE_LENGTH.getMessage()
            );
        }
    }

    private static void validateMaximumRange(int size) {
        if (size > AvailableInput.getBridgeMaximumSizeValue()) {
            throw new IllegalArgumentException(
                    ExceptionMessage.BIGGER_THAN_MAXIMUM_BRIDGE_LENGTH.getMessage()
            );
        }
    }

    private static int stringToInteger(String input) {
        return Integer.valueOf(input);
    }
}