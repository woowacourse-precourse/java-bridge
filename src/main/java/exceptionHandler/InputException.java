package exceptionHandler;

import enumCollections.AvailableInput;
import enumCollections.ExceptionMessage;

public class InputException {
    protected static void validateCommonException(String input) {
        validateNullString(input);
    }

    protected static void validateMinimumRange(int size) {
        if (size < AvailableInput.getBridgeMinimumSizeValue()) {
            throw new IllegalArgumentException(
                    ExceptionMessage.SMALLER_THAN_MINIMUM_BRIDGE_LENGTH.getMessage()
            );
        }
    }

    protected static void validateMaximumRange(int size) {
        if (size > AvailableInput.getBridgeMaximumSizeValue()) {
            throw new IllegalArgumentException(
                    ExceptionMessage.BIGGER_THAN_MAXIMUM_BRIDGE_LENGTH.getMessage()
            );
        }
    }

    private static void validateNullString(String value) {
        if (value.isBlank()) {
            throw new IllegalArgumentException(ExceptionMessage.EMPTY_STRING.getMessage());
        }
    }
}