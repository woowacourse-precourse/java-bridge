package bridge.validation;

import static bridge.constants.ErrorMessage.*;
import static bridge.domain.GameCommand.QUIT;
import static bridge.domain.GameCommand.RETRY;
import static bridge.domain.Moving.DOWN;
import static bridge.domain.Moving.UP;

public class InputValidation {

    public static void validateReadBridgeSize(String size) {
        if (!isNumeric(size) || !isCorrectRange(size)) {
            throw new IllegalArgumentException(INVALID_BRIDGE_SIZE_ERROR.getMessage());
        }
    }

    private static boolean isNumeric(String input) {
        boolean isNumeric = input.matches("[+-]?\\d*(\\.\\d+)?");
        return isNumeric;
    }

    private static boolean isCorrectRange(String input) {
        int numericInput = Integer.parseInt(input);
        if (numericInput >= 3 && numericInput <= 20) {
            return true;
        }
        return false;
    }

    public static void validateReadMoving(String moving) {
        if (!moving.equals(UP.getMoving()) && !moving.equals(DOWN.getMoving())) {
            throw new IllegalArgumentException(INVALID_MOVING_ERROR.getMessage());
        }
    }

    public static void validateReadGameCommand(String gameCommand) {
        if (!gameCommand.equals(RETRY.getGameCommand()) && !gameCommand.equals(QUIT.getGameCommand())) {
            throw new IllegalArgumentException(INVALID_GAME_COMMAND_ERROR.getMessage());
        }
    }
}
