package exceptionHandler;

import enumCollections.AvailableInput;
import enumCollections.ExceptionMessage;
import enumCollections.Side;

public class InputException {
    protected static void validateCommonException(String input) {
        validateNullString(input);
    }

    protected static void validateCharactersOnly(String value) {
        if (value.matches(AvailableInput.NUMERIC_RANGE.getUserInput())) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_CHARACTER.getMessage());
        }
    }

    private static void validateNullString(String value) {
        if (value.isBlank()) {
            throw new IllegalArgumentException(ExceptionMessage.EMPTY_STRING.getMessage());
        }
    }
}