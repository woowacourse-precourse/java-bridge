package bridge.util;

import static bridge.util.Constants.*;

import java.util.Arrays;

public class InputValidator {
    private static final String NO_SPACE = "";
    private static final String NON_DIGIT_CHARACTER = "[^0-9]";
    private static final String NON_ALPHABETIC_CHARACTER = "[^a-zA-Z]";

    public static void bridgeSize(String input) {
        validateBlank(input);
        validateNumericType(input);
        validateRange(Integer.parseInt(input));
    }

    public static void moving(String input) {
        validateBlank(input);
        validateAlphabeticType(input);

        if (isNotKeyForUp(input) && isNotKeyForDown(input)) {
            throw new IllegalArgumentException(ERROR_TITLE + MOVING_FORMAT);
        }
    }

    public static void gameCommand(String input) {
        validateBlank(input);
        validateAlphabeticType(input);

        if (isNotKeyForRetry(input) && isNotKeyForQuit(input)) {
            throw new IllegalArgumentException(ERROR_TITLE + COMMAND_FORMAT);
        }
    }

    private static void validateBlank(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException(ERROR_TITLE + EMPTY_INPUT);
        }
    }

    private static void validateNumericType(String input) {
        if (hasInvalidCharacter(input, NON_DIGIT_CHARACTER)) {
            throw new IllegalArgumentException(ERROR_TITLE + NON_DIGIT_CHARACTER_FOUND);
        }
    }

    private static void validateRange(int size) {
        if (size < MINIMUM_BRIDGE_SIZE || size > MAXIMUM_BRIDGE_SIZE) {
            throw new IllegalArgumentException(ERROR_TITLE + BRIDGE_SIZE_FORMAT);
        }
    }

    private static void validateAlphabeticType(String input) {
        if (hasInvalidCharacter(input, NON_ALPHABETIC_CHARACTER)) {
            throw new IllegalArgumentException(ERROR_TITLE + NON_ALPHABETIC_CHARACTER_FOUND);
        }
    }

    private static boolean hasInvalidCharacter(String input, String regex) {
        final String[] splitted = input.split(NO_SPACE);

        return Arrays.stream(splitted)
                .anyMatch(element ->
                        element.matches(regex)
                );
    }

    private static boolean isNotKeyForUp(String input) {
        return (!CommandKeys.isUp(input.toUpperCase()));
    }

    private static boolean isNotKeyForDown(String input) {
        return (!CommandKeys.isDown(input.toUpperCase()));
    }

    private static boolean isNotKeyForRetry(String input) {
        return (!CommandKeys.isRetry(input.toUpperCase()));
    }

    private static boolean isNotKeyForQuit(String input) {
        return (!CommandKeys.isQuit(input.toUpperCase()));
    }
}
