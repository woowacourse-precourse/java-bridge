package bridge.util;

import bridge.model.Command;

public class InputCommandValidator {
    private static final String ERROR_MOVE_COMMAND = String.format("[ERROR] 종료는 %s, 재시작은 %s로 입력 가능합니다.",
            Command.QUIT.getCommand(), Command.RETRY.getCommand());

    public static void validator(String input) {
        validateCommand(input);
    }

    private static void validateCommand(String input) {
        if (!input.equals(Command.RETRY.getCommand()) && !input.equals(Command.QUIT.getCommand())) {
            throw new IllegalArgumentException(ERROR_MOVE_COMMAND);
        }
    }
}
