package bridge.util;

public class Validator {

    private static final int MIN_BRIDGE_SIZE = 3;
    private static final int MAX_BRIDGE_SIZE = 20;

    public static void validateNumericInputType(String input) {
        if (input.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException("숫자만 입력 가능합니다");
        }
    }

    public static void validateBridgeSize(int size) {
        if (size < MIN_BRIDGE_SIZE || size > MAX_BRIDGE_SIZE) {
            throw new IllegalArgumentException("3~20 이내로만 입력 가능합니다");
        }
    }

    public static void validateMovingInput(String input) {
        if (!input.equals("U") || input.equals("D")) {
            throw new IllegalArgumentException("U 또는 D만 입력 가능합니다");
        }
    }

    public static void validateGameCommandInput(String input) {
        if (!input.equals("R") || input.equals("Q")) {
            throw new IllegalArgumentException("R 또는 Q만 입력 가능합니다");
        }
    }
}
