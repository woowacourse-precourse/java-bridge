package bridge.model;

import static bridge.enums.ErrorMsg.*;
import static bridge.enums.Constant_BridgeGame.*;

public class InputValidator {

    private static final int BRIDGE_SIZE_LOWER_INCLUSIVE = 3;
    private static final int BRIDGE_SIZE_UPPER_INCLUSIVE = 20;

    public void BridgeSize(int size) {
        if (size < BRIDGE_SIZE_LOWER_INCLUSIVE || size > BRIDGE_SIZE_UPPER_INCLUSIVE) {
            throw new IllegalArgumentException(ERROR_PREFIX.get() + ERROR_BRIDGE_SIZE_IS_NOT_BETWEEN_3_AND_20.get());
        }
    }

    public void Moving(String input) {
        if (!input.equals(GAME_COMMAND_UP.get()) && !input.equals(GAME_COMMAND_DOWN.get())) {
            throw new IllegalArgumentException(ERROR_PREFIX.get() + ERROR_MOVING_IS_NOT_U_OR_D.get());
        }
    }

    public void GameCommand(String input) {
        if (!input.equals(GAME_COMMAND_RETRY.get()) && !input.equals(GAME_COMMAND_QUIT.get())) {
            throw new IllegalArgumentException(ERROR_PREFIX.get() + ERROR_GAME_COMMAND_IS_NOT_R_OR_Q.get());
        }
    }
}
