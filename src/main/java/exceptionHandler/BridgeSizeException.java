package exceptionHandler;

import enumCollections.AvailableInput;
import enumCollections.ExceptionMessage;

public class BridgeSizeException {
    private static final String NUMERIC = "^[0-9]*$";


    public static void validate(String size) {
        validateNumeric(size);
        validateMinimumRange(stringToInteger(size));
        validateMaximumRange(stringToInteger(size));
    }

    private static void validateNumeric(String size) {
        if (!size.matches(NUMERIC)) {
            throw new IllegalArgumentException(ExceptionMessage.getMessage(ExceptionMessage.NOT_NUMERIC));
        }
    }

    private static void validateMinimumRange(int size) {
        if (size < AvailableInput.getBridgeSizeRange(AvailableInput.BRIDGE_MINIMUM_SIZE)) {
            throw new IllegalArgumentException(
                    ExceptionMessage.getMessage(ExceptionMessage.SMALLER_THAN_MINIMUM_BRIDGE_LENGTH)
            );
        }
    }

    private static void validateMaximumRange(int size) {
        if (size > AvailableInput.getBridgeSizeRange(AvailableInput.BRIDGE_MAXIMUM_SIZE)) {
            throw new IllegalArgumentException(
                    ExceptionMessage.getMessage(ExceptionMessage.BIGGER_THAN_MAXIMUM_BRIDGE_LENGTH)
            );
        }
    }

    private static int stringToInteger(String input) {
        return Integer.valueOf(input);
    }
}
