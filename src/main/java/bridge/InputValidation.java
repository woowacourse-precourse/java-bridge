package bridge;

import static bridge.ErrorMessage.*;

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
        if (!moving.equals("U") && !moving.equals("D")) {
            throw new IllegalArgumentException(INVALID_MOVING_ERROR.getMessage());
        }
    }

    public static void validateReadGameCommand(String gameCommand) {
        if (!gameCommand.equals("R") && !gameCommand.equals("Q")) {
            throw new IllegalArgumentException(INVALID_GAME_COMMAND_ERROR.getMessage());
        }
    }
}
