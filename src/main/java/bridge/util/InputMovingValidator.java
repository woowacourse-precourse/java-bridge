package bridge.util;

import bridge.model.Command;

public class InputMovingValidator {
    private static final String ERROR_MOVE_COMMAND = String.format("[ERROR] 이동은 %s 또는 %s로만 입력 가능합니다.",
            Command.UP.getCommand(), Command.DOWN.getCommand());

    public static void validator(String input) {
        validateMove(input);
    }

    private static void validateMove(String input) {
        if (!input.equals(Command.UP.getCommand()) && !input.equals(Command.DOWN.getCommand())) {
            throw new IllegalArgumentException(ERROR_MOVE_COMMAND);
        }
    }
}
