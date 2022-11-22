package bridge.utils;

import bridge.domain.Pos;

public class Valid {

    private static final int MIN_BRIDGE = 3;
    private static final int MAX_BRIDGE = 20;

    public static void isNumeric(String input) {
        if (!input.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException("숫자를 입력해주세요.");
        }
    }

    public static void isCorrectRange(String input) {
        int num = Integer.parseInt(input);
        if (num < MIN_BRIDGE || num > MAX_BRIDGE) {
            throw new IllegalArgumentException(MIN_BRIDGE + "부터 " + MAX_BRIDGE + " 사이의 숫자여야 합니다.");
        }
    }

    public static void isCorrectPos(String input) {
        for (Pos pos : Pos.values()) {
            if (pos.name().equals(input)) {
                return;
            }
        }
        throw new IllegalArgumentException("U나 D만 입력할 수 있습니다.");
    }

    public static void isCorrectCommand(String input) {
        if (input.equals("R") || input.equals("Q")) {
            return;
        }
        throw new IllegalArgumentException("R이나 Q만 입력할 수 있습니다.");

    }
}
