package bridge.validator;

import static bridge.validator.ExceptionMessage.*;

public class BridgeSizeValidator {
    private static final int MIN_SIZE = 3;
    private static final int MAX_SIZE = 20;
    private static final String EMPTY_VALUE = "";

    public static void validate(String size) {
        validateDigit(size);
        validateBlank(size);
        validateSize(toInt(size));
    }

    private static void validateBlank(String size) {
        if (isBlank(size)) {
            throw new NumberFormatException(NO_BLANK_MESSAGE.getMessage());
        }
    }

    private static boolean isBlank(String size) {
        return size.trim().equals(EMPTY_VALUE);
    }

    private static void validateDigit(String size) {
        if (isDigit(size)) {
            throw new IllegalArgumentException(NO_NUMBER_MESSAGE.getMessage());
        }
    }

    private static void validateSize(int size) {
        if (size < MIN_SIZE || size > MAX_SIZE) {
            throw new IllegalArgumentException(OVER_OR_UNDER_RANGE_MESSAGE.getMessage());
        }
    }

    private static boolean isDigit(String size) {
        return !size.chars().allMatch(Character::isDigit);
    }

    private static int toInt(String size) {
        return Integer.parseInt(size);
    }
}
