package bridge.view;

import java.util.Arrays;

public class InputValidator {
    private static final int MINIMUM_BRIDGE_SIZE = 3;
    private static final int MAXIMUM_BRIDGE_SIZE = 20;

    private static final String NO_SPACE = "";
    private static final String NON_DIGIT_CHARACTER = "[^0-9]";
    private static final String NON_ALPHABETIC_CHARACTER = "[^a-zA-Z]";

    public static void gameCommand(String input) {
        validateBlank(input);
        validateAlphabeticType(input);
        validateAnswerToRetry(input.toUpperCase());
    }

    private static void validateAnswerToRetry(String input) {
        if (!isRetry(input) && !isQuit(input)) {
            throw new IllegalArgumentException("[ERROR] 게임 재개 여부는 \"R\" 또는 \"Q\"만 입력할 수 있습니다.");
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
            throw new IllegalArgumentException("[ERROR] 오직 알파벳 형태만 입력할 수 있습니다.");
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
            throw new IllegalArgumentException("[ERROR] 이동할 칸은 \"U\" 또는 \"D\"로 입력되어야 합니다.");
        }
    }

    private static boolean isUp(String input) {
        return input.equals("U");
    }

    private static boolean isDown(String input) {
        return input.equals("D");
    }

    public static void bridgeSize(String input) {
        validateBlank(input);
        validateNumericType(input);
        validateRange(Integer.parseInt(input));
    }

    private static void validateBlank(String input) {
        if (input == null | input.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 입력된 값이 없습니다.");
        }
    }

    private static void validateNumericType(String input) {
        if (isNotNumeric(input)) {
            throw new IllegalArgumentException("[ERROR] 다리 길이는 오직 숫자 형태만 받을 수 있습니다.");
        }
    }

    private static void validateRange(int size) {
        if (size < MINIMUM_BRIDGE_SIZE || size > MAXIMUM_BRIDGE_SIZE) {
            throw new IllegalArgumentException(
                    String.format(
                            "[ERROR] 다리 길이는 %d부터 %d 사이의 숫자여야 합니다.",
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
}
