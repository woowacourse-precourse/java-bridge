package bridge.support.validator;

public final class InputValidator {
    private static final String NOT_A_NUMBER_MESSAGE = "[ERROR] 숫자를 입력해주세요.";
    private static final String INVALID_MOVING_SIGN_MESSAGE = "[ERROR] 이동할 칸은 U또는 D만 입력 가능합니다";
    private static final String UP_SIGN = "U";
    private static final String DOWN_SIGN = "D";

    private InputValidator() {}

    public static void validateParseStringToInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_A_NUMBER_MESSAGE);
        }
    }

    public static void validateMoving(String input) {
        if (input.equals(UP_SIGN) || input.equals(DOWN_SIGN)) {
            return;
        }
        throw new IllegalArgumentException(INVALID_MOVING_SIGN_MESSAGE);
    }
}
