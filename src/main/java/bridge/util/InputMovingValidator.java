package bridge.util;

import bridge.model.Move;

public class InputMovingValidator {
    private static final String ERROR_MOVE_COMMAND = String.format("[ERROR] 이동은 %s 또는 %s로만 입력 가능합니다.",
            Move.UP.getCommand(), Move.DOWN.getCommand());

    public static void validator(String input) {
        validateMove(input);
    }

    private static void validateMove(String input) {
        if (!input.equals(Move.UP.getCommand()) && !input.equals(Move.DOWN.getCommand())) {
            throw new IllegalArgumentException(ERROR_MOVE_COMMAND);
        }
    }
}
