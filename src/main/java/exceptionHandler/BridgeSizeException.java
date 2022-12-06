package exceptionHandler;

import enumCollections.AvailableInput;
import enumCollections.ExceptionMessage;

public class BridgeSizeException extends InputException {
    public static void validate(String size) {
        validateCommonException(size);
        validateNumericOnly(size);
        validateMinimumRange(stringToInteger(size));
        validateMaximumRange(stringToInteger(size));
    }

    private static void validateNumericOnly(String size) {
        if (!size.matches(AvailableInput.NUMERIC_RANGE.getUserInput())) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_NUMERIC.getMessage());
        }
    }

    private static int stringToInteger(String input) {
        return Integer.valueOf(input);
    }
}