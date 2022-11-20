package bridge.validator;

import bridge.constant.Constant;
import bridge.constant.ErrorMessage;

public class GameCommandValidator {
    public static void validateGameCommand(String input) {
        if (!input.equals(Constant.RESTART) && !input.equals(Constant.QUIT)) {
            throw new IllegalArgumentException(ErrorMessage.WRONG_GAME_COMMAND_VALUE);
        }
    }
}
