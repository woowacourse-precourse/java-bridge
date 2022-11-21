package bridge.validation;

import static bridge.constant.ErrorMessage.*;
import static bridge.constant.GameCommand.*;
import static bridge.constant.Updown.*;

public class Validation {
    public void validateBridgeSize(String bridgeSize) {
        try {
            int size = Integer.parseInt(bridgeSize);
            if ((size < 3) || (size > 20)) {
                throw new IllegalArgumentException(BRIDGE_SIZE_ERROR);
            }
        } catch(NumberFormatException e) {
            throw new IllegalArgumentException(BRIDGE_SIZE_ERROR);
        }
    }

    public void validateMoving(String moving) {
        if (moving.equals(UP.getKey()) || moving.equals(DOWN.getKey())) {
            return;
        }
        throw new IllegalArgumentException(MOVING_ERROR);
    }

    public void validateGameCommand(String gameCommand) {
        if (gameCommand.equals(RETRY.getKey()) || gameCommand.equals(QUIT.getKey())) {
            return;
        }
        throw new IllegalArgumentException(GAME_COMMAND_ERROR);
    }
}
