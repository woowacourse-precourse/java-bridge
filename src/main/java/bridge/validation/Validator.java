package bridge.validation;

import static bridge.exception.ErrorEnum.INVALID_BRIDGE_GAME_MOVE_STATUS;
import static bridge.exception.ErrorEnum.INVALID_DIRECTION_INPUT;
import static bridge.game.BridgeGameStatus.RUNNING;

import bridge.game.BridgeGameStatus;

public class Validator {

    public static void validateStatusAtMove(BridgeGameStatus status) {
        if (!status.equals(RUNNING)) {
            throw new IllegalStateException(INVALID_BRIDGE_GAME_MOVE_STATUS
                    .messageWithCause(status.text()));
        }
    }

    public static void validateDirectionInput(String input) {
        if (!input.equals("U") && !input.equals("D")) {
            throw new IllegalArgumentException(INVALID_DIRECTION_INPUT
                    .messageWithCause(input));
        }
    }
}
