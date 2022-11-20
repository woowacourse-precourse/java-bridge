package bridge.validator;

import static bridge.util.BridgeGameConstant.QUIT_SIGN;
import static bridge.util.BridgeGameConstant.RESTART_SIGN;
import static bridge.validator.ErrorStatus.DIRECTION_SIGN_ERROR;

public class GameCommandValidator {
    public static void validate(String gameCommand) {
        if (!RESTART_SIGN.equals(gameCommand) && !QUIT_SIGN.equals(gameCommand)) {
            throw new IllegalArgumentException(DIRECTION_SIGN_ERROR.getMessage());
        }
    }
}
