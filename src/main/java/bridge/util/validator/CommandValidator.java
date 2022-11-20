package bridge.util.validator;

import bridge.engine.GameCommand;

import static bridge.util.ErrorLevel.ERROR;
import static bridge.view.ErrorMessage.*;

public class CommandValidator extends Validator {

    @Override
    public void check(final String input) {
        if (!isAlpha(input)) {
            throw new IllegalArgumentException(ERROR.toMessage() + NOT_ALPHABETIC);
        }

        if (!GameCommand.isMatch(input)) {
            throw new IllegalArgumentException(ERROR.toMessage() + INVALID_GAME_COMMAND);
        }
    }
}
