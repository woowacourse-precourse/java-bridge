package bridge.validator;

public class GameRetryValidator {

    public static final String ERROR_PREFIX = "[ERROR] ";

    public static void validate(String input) throws IllegalArgumentException {
        typeCheck(input);
    }

    public static void typeCheck(String input) {
        if (!input.equals("R") && !input.equals("Q")) {
            throw new IllegalArgumentException(ERROR_PREFIX + "입력값이 Y 또는 N이 아닙니다.");
        }
    }
}
