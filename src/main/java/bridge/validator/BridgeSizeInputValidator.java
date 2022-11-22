package bridge.validator;

public class BridgeSizeInputValidator {

    public static final String ERROR_PREFIX = "[ERROR] ";
    private static final int MIN_SIZE = 3;
    private static final int MAX_SIZE = 20;

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
        if (Integer.parseInt(input) < MIN_SIZE || Integer.parseInt(input) > MAX_SIZE) {
            throw new IllegalArgumentException(ERROR_PREFIX + "다리의 크기는" + MIN_SIZE + "~" + MAX_SIZE + "이여야 합니다.");
        }
    }
}
