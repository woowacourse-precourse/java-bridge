package bridge.validator;

public class BridgeSizeInputValidator {

    public static final String ERROR_PREFIX = "[ERROR] ";

    public static void validate(String input) throws IllegalArgumentException {
        typeCheck(input);
        rangeCheck(input);
    }

    public static void typeCheck(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_PREFIX + "입력값이 숫자가 아닙니다.");
        }
    }

    public static void rangeCheck(String input) {
        if (Integer.parseInt(input) < 3 || Integer.parseInt(input) > 20) {
            throw new IllegalArgumentException(ERROR_PREFIX + "다리의 크기는 3 ~ 20 이여야 합니다.");
        }
    }
}
