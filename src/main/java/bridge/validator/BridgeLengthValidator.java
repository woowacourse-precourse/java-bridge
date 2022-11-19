package bridge.validator;

public class BridgeLengthValidator {

    private static final int MIN_RANGE = 3;
    private static final int MAX_RANGE = 20;
    public static final String BRIDGE_LENGTH_MESSAGE = "[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.";

    public static void validateNaturalNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(BRIDGE_LENGTH_MESSAGE);
        }
    }

    public static void validateRange(String input) {
        if (Integer.parseInt(input) < MIN_RANGE || Integer.parseInt(input) > MAX_RANGE) {
            throw new IllegalArgumentException(BRIDGE_LENGTH_MESSAGE);
        }
    }
}
