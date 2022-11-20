package bridge.view;

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

    private static void validateBlank(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException(ERROR_TITLE + EMPTY_INPUT);
        }
    }

    private static void validateNumericType(String input) {
        if (isNotNumeric(input)) {
            throw new IllegalArgumentException(ERROR_TITLE + NON_NUMERIC_CHARACTER_FOUND);
        }
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

    private static boolean isNotNumeric(String input) {
        final String[] splitted = input.split(NO_SPACE);

        return Arrays.stream(splitted)
                .anyMatch(element ->
                        element.matches(NON_DIGIT_CHARACTER)
                );
    }

    public static void gameCommand(String input) {
        validateBlank(input);
        validateAlphabeticType(input);
        validateAnswerToRetry(input.toUpperCase());
    }

    private static void validateAnswerToRetry(String input) {
        if (!isRetry(input) && !isQuit(input)) {
            throw new IllegalArgumentException(ERROR_TITLE + COMMAND_FORMAT);
        }
    }

    private static boolean isRetry(String input) {
        // 템플릿 메소드(hasSameMeaning)로 분리 & 각 상수는 enum으로 관리해서 이름 명시
        return input.equals("R");
    }

    private static boolean isQuit(String input) {
        return input.equals("Q");
    }

    public static void moving(String input) {
        validateBlank(input);
        validateAlphabeticType(input);
        validateDirection(input.toUpperCase());
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

    private static void validateDirection(String input) {
        if (!isUp(input) && !isDown(input)) {
            throw new IllegalArgumentException(ERROR_TITLE + MOVING_FORMAT);
        }
    }

    private static boolean isUp(String input) {
        return input.equals("U");
    }

    private static boolean isDown(String input) {
        return input.equals("D");
    }

}
