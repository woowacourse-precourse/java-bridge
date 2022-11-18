package bridge.support.validator;

public final class InputValidator {
    private static final String NOT_A_NUMBER_MESSAGE = "[ERROR] 숫자를 입력해주세요.";

    private InputValidator() {}

    public static void validateParseStringToInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_A_NUMBER_MESSAGE);
        }
    }
}
