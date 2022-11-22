package bridge.utils;

import bridge.domain.Direction;

public class Validator {
    public static void validateBridgeSize(String input) {
        int size = isDigit(input);
        inRange(Value.MIN_BRIDGE_SIZE, Value.MAX_BRIDGE_SIZE, size);
    }

    public static void validateMove(String input) {
        if (!input.equals(Direction.UP.getCommand()) && !input.equals(Direction.DOWN.getCommand())) {
            throw new IllegalArgumentException("U또는 D를 입력해주세요");
        }
    }

    public static void validateGameCommand(String input) {
        if (!input.equals(Value.RETRY) && !input.equals(Value.QUIT)) {
            throw new IllegalArgumentException("R또는 Q를 입력해주세요");
        }
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
