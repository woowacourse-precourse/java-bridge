package bridge;

import static bridge.ErrorMessage.*;

public class Validator {
    private static final String UP = "U";
    private static final String DOWN = "D";
    private static final String RESTART = "R";
    private static final String QUIT = "Q";

    public static int validateBridgeSize(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_BRIDGE_SIZE.getMessage());
        }
    }

    public static String validateMoving(String moving) {
        if (UP.equals(moving) || DOWN.equals(moving)) {
            return moving;
        }
        throw new IllegalArgumentException(INVALID_MOVING_VALUE.getMessage());
    }

    public static String validateGameCommand(String gameCommand) {
        if (RESTART.equals(gameCommand) || QUIT.equals(gameCommand)) {
            return gameCommand;
        }
        throw new IllegalArgumentException(INVALID_GAME_COMMAND_VALUE.getMessage());
    }
}
