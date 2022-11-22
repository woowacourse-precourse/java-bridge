package bridge.util.validator;

import static bridge.util.constants.GameCommand.RETRY;
import static bridge.util.constants.GameCommand.QUIT;
import static bridge.util.constants.ErrorMessage.GAME_COMMAND_INPUT_ERROR;

public class GameCommandValidator {
    public static void validate(String input) {
        if (!input.equals(RETRY.command()) && !input.equals(QUIT.command())) {
            String errorMessage = String.format(GAME_COMMAND_INPUT_ERROR.getMessage(),
                    RETRY.command(), QUIT.command());
            throw new IllegalArgumentException(errorMessage);
        }
    }
}
