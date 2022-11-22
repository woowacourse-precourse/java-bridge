package bridge.model.validation;

import bridge.model.constnce.CustomErrorMessage;

import java.util.Arrays;
import java.util.Objects;

public enum Move {
    MOVE_UP("U", 1),
    MOVE_DOWN("D", 0);

    private final String moveKey;
    private final int moveValue;

    Move(String moveKey, int moveValue) {
        this.moveKey = moveKey;
        this.moveValue = moveValue;
    }

    public String getMoveKey() {
        return moveKey;
    }

    public int getMoveValue() {
        return moveValue;
    }

    public boolean isEquals(String randomKey, Move move) {
        return Objects.equals(move.getMoveKey(), randomKey);
    }

    // 사용자로부터 입력
    public static Move of(String input) {
        validate(input);

        if (MOVE_UP.moveKey.equals(input)) {
            return MOVE_UP;
        }
        return MOVE_DOWN;
    }

    public static Move of(int randomValue) {
        if (MOVE_UP.moveValue == randomValue) {
            return MOVE_UP;
        }
        return MOVE_DOWN;
    }

    private static void validate(String input) {
        checkUppercase(input);
        checkCorrectKey(input);
    }

    private static void checkUppercase(String input) {
        if (!input.equals(input.toUpperCase())) {
            throw new IllegalArgumentException(CustomErrorMessage.IS_NOT_UPPERCASE.getMessage());
        }
    }

    private static void checkCorrectKey(String input) {
        if (isIncorrect(input)) {
            throw new IllegalArgumentException(CustomErrorMessage.INCORRECT_KEY_INPUT.getMessage());
        }
    }

    private static boolean isIncorrect(String input) {
        return Arrays.stream(Move.values()).noneMatch(e -> e.moveKey.equals(input));
    }

}
