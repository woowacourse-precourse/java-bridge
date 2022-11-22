package bridge;

import bridge.enums.InputConstants;
import bridge.enums.InputExceptionConstants;

public class Validator {

    public static void isNumeric(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(InputExceptionConstants.NONE_NUMERIC.getMessage());
        }
    }

    public static void isInRange(int input) {
        if (input < 3 || input > 20) {
            throw new IllegalArgumentException(InputExceptionConstants.BRIDGE_RANGE.getMessage());
        }
    }

    public static void isMoveCommand(String input) {
        if (!input.equals(InputConstants.UP_MOVE.getValue()) && !input.equals(InputConstants.DOWN_MOVE.getValue())) {
            throw new IllegalArgumentException(InputExceptionConstants.MOVE_COMMAND.getMessage());
        }
    }

    public static void isGameCommand(String input) {
        if (!input.equals(InputConstants.RETRY_GAME.getValue()) && !input.equals(InputConstants.QUIT_GAME.getValue())) {
            throw new IllegalArgumentException(InputExceptionConstants.GAME_COMMAND.getMessage());
        }
    }

}
