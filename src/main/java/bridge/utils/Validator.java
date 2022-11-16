package bridge.utils;

public class Validator {
    private static final int MIN_BRIDGE_SIZE = 3;
    private static final int MAX_BRIDGE_SIZE = 20;
    public static void validateBridgeSize(String input) {
        int size = isDigit(input);
        inRange(MIN_BRIDGE_SIZE, MAX_BRIDGE_SIZE, size);
    }

    private static int isDigit(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닙니다");
        }
    }

    private static void inRange(int startInclusive, int endInclusive, int value) {
        if (startInclusive > value || endInclusive < value) {
            throw new IllegalArgumentException("범위를 벗어났습니다");
        }
    }
}
