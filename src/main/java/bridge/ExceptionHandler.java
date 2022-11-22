package bridge;

import data.Errors;

public class ExceptionHandler {
    public static void checkNumeric(String input) throws IllegalArgumentException {
        if (!isNumeric(input)) {
            throw new IllegalArgumentException(Errors.NOT_NUMERIC.getMessage());
        }
    }

    private static boolean isNumeric(String input) {
        return input != null && input.matches("^[0-9]*$");
    }

    public static void checkLengthRange(int input) throws IllegalArgumentException {
        if (isRange(input)) {
            throw new IllegalArgumentException(Errors.NOT_RANGE.getMessage());
        }
    }

    private static boolean isRange(int input) {
        return input < 3 || input > 20;
    }
}
