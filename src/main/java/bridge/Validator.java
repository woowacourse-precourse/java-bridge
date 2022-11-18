package bridge;

public final class Validator {
    private static final String PREFIX = "[ERROR] ";
    private static final String BLANK_STRING = PREFIX + "공백일 수 없습니다.";
    private static final String NOT_INTEGER = PREFIX + "숫자만 입력해 주세요.";

    private Validator() {

    }

    public static void validateBlank(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException(BLANK_STRING);
        }
    }

    public static void validateInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_INTEGER);
        }
    }
}
