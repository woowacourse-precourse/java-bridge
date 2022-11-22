package bridge.validator;

public class BridgeMoveInputValidator {

    public static final String ERROR_PREFIX = "[ERROR] ";

    public static void validate(String input) throws IllegalArgumentException {
        sizeCheck(input);
        typeCheck(input);
    }

    public static void sizeCheck(String input) {
        if (input.length() != 1) {
            throw new IllegalArgumentException(ERROR_PREFIX + "입력값이 1자리가 아닙니다.");
        }
    }

    public static void typeCheck(String input) {
        if (!input.equals("U") && !input.equals("D")) {
            throw new IllegalArgumentException(ERROR_PREFIX + "입력값이 U 또는 D가 아닙니다.");
        }
    }

}
