package bridge.validator;

import static bridge.util.BridgeGameConstant.QUIT_SIGN;
import static bridge.util.BridgeGameConstant.RESTART_SIGN;
import static bridge.validator.ErrorStatus.GAME_COMMAND_SIGN_ERROR;

public class GameCommandValidator implements Validator {
    public GameCommandValidator() {
    }

    @Override
    public void validate(String gameCommand) {
        if (!RESTART_SIGN.equals(gameCommand) && !QUIT_SIGN.equals(gameCommand)) {
            throw new IllegalArgumentException(GAME_COMMAND_SIGN_ERROR.getMessage());
        }
    }
}
