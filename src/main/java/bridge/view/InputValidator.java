package bridge.view;

import java.util.Arrays;

public class InputValidator {
    private static final int MINIMUM_BRIDGE_SIZE = 3;
    private static final int MAXIMUM_BRIDGE_SIZE = 20;

    private static final String NO_SPACE = "";
    private static final String NON_DIGIT_CHARACTER = "[^0-9]";

    public static void bridgeSize(String input) {
        validateNumericType(input);
        validateRange(Integer.parseInt(input));
    }

    private static void validateNumericType(String input) {
        if (isNotNumeric(input)) {
            throw new IllegalArgumentException("[ERROR] 입력값은 숫자 형태만 받을 수 있습니다.");
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
