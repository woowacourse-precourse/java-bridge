package bridge.view;

import static bridge.util.Constants.*;

import bridge.util.CommandKeys;
import java.util.Arrays;

public class InputValidator {
    private static final String NO_SPACE = "";
    private static final String NON_DIGIT_CHARACTER = "[^0-9]";
    private static final String NON_ALPHABETIC_CHARACTER = "[^a-zA-Z]";

    public static void bridgeSize(String input) {
        validateNumericType(input);
        validateRange(Integer.parseInt(input));
    }

    private static void validateNumericType(String input) {
        if (isNotNumeric(input)) {
            throw new IllegalArgumentException(ERROR_TITLE + NON_NUMERIC_CHARACTER_FOUND);
        }
    }

    private static boolean isNotNumeric(String input) {
        final String[] splitted = input.split(NO_SPACE);

        return Arrays.stream(splitted)
                .anyMatch(element ->
                        element.matches(NON_DIGIT_CHARACTER)
                );
    }

    private static void validateRange(int size) {
        if (size < MINIMUM_BRIDGE_SIZE || size > MAXIMUM_BRIDGE_SIZE) {
            throw new IllegalArgumentException(ERROR_TITLE +
                    String.format(
                            BRIDGE_SIZE_FORMAT,
                            MINIMUM_BRIDGE_SIZE,
                            MAXIMUM_BRIDGE_SIZE
                    ));
        }
    }

    public static void moving(String input) {
        validateAlphabeticType(input);
        if (!isUp(input) && !isDown(input)) {
            throw new IllegalArgumentException(ERROR_TITLE + MOVING_FORMAT);
        }
    }

    public static void gameCommand(String input) {
        validateAlphabeticType(input);
        if (!isRetry(input) && !isQuit(input)) {
            throw new IllegalArgumentException(ERROR_TITLE + COMMAND_FORMAT);
        }
    }

    private static void validateAlphabeticType(String input) {
        if (isNotAlphabetic(input)) {
            throw new IllegalArgumentException(ERROR_TITLE + NON_ALPHABETIC_CHARACTER_FOUND);
        }
    }

    private static boolean isNotAlphabetic(String input) {
        final String[] splitted = input.split(NO_SPACE);

        return Arrays.stream(splitted)
                .anyMatch(element ->
                        element.matches(NON_ALPHABETIC_CHARACTER)
                );
    }

    private static boolean isUp(String input) {
        return CommandKeys.isSame(CommandKeys.UP, input.toUpperCase());
    }

    private static boolean isDown(String input) {
        return CommandKeys.isSame(CommandKeys.DOWN, input.toUpperCase());
    }

    private static boolean isRetry(String input) {
        return CommandKeys.isSame(CommandKeys.RETRY, input.toUpperCase());
    }

    private static boolean isQuit(String input) {
        return CommandKeys.isSame(CommandKeys.QUIT, input.toUpperCase());
    }
}
