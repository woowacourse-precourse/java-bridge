package bridge.view;

import static bridge.util.Constants.*;

import bridge.util.CapitalLetter;
import java.util.Arrays;

public class InputValidator {
    private static final String NO_SPACE = "";
    private static final String NON_DIGIT_CHARACTER = "[^0-9]";

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

    public static void moving(CapitalLetter letter) {
        if (!isUp(letter) && !isDown(letter)) {
            throw new IllegalArgumentException(ERROR_TITLE + MOVING_FORMAT);
        }
    }

    private static boolean isUp(CapitalLetter letter) {
        return letter.isUp();
    }

    private static boolean isDown(CapitalLetter letter) {
        return letter.isDown();
    }

    public static void gameCommand(CapitalLetter letter) {
        if (!isRetry(letter) && !isQuit(letter)) {
            throw new IllegalArgumentException(ERROR_TITLE + COMMAND_FORMAT);
        }
    }

    private static boolean isRetry(CapitalLetter letter) {
        return letter.isRetry();
    }

    private static boolean isQuit(CapitalLetter letter) {
        return letter.isQuit();
    }
}
