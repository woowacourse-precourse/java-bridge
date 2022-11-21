package bridge.validation;

public class InputBridgeNumberValidator {

    private static final String INVALID_TYPE = "다리 길이는 숫자여야 합니다.";
    private static final String INVALID_RANGE = "다리 길이는 3부터 20 사이의 숫자여야 합니다.";

    private static final Integer MIN_NUMBER = 3;
    private static final Integer MAX_NUMBER = 20;

    public static void validateInputBridgeNumber(String input) {
        Integer number = validateNumber(input);
        validateBridgeSize(number);
    }

    public static Integer validateNumber(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_TYPE);
        }
    }

    public static void validateBridgeSize (Integer number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException(INVALID_RANGE);
        }
    }
}
