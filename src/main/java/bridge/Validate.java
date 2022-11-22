package bridge;

import bridge.constant.Error;
import bridge.constant.GameCommand;

public class Validate {

    private static final String error = Error.ERROR.getMessage();
    private static final int BRIDGE_SIZE_LOWER_BOUND = 3;
    private static final int BRIDGE_SIZE_UPPER_BOUND = 20;

    public static void checkBridgeSize(String length) {
        if (notNumeric(length)) {
            throw new IllegalArgumentException(error + Error.BRIDGE_SIZE_NOT_NUMERIC.getMessage());
        }
        if (notInRange(length)) {
            throw new IllegalArgumentException(error + Error.BRIDGE_SIZE_NOT_IN_RANGE.getMessage());
        }
    }

    public static boolean notNumeric(String length) {
        return !length.chars()
                .allMatch(Character::isDigit);
    }

    public static boolean notInRange(String length) {
        return Integer.parseInt(length) < BRIDGE_SIZE_LOWER_BOUND || Integer.parseInt(length) > BRIDGE_SIZE_UPPER_BOUND;
    }

    public static void checkMoveDirection(String direction) {
        if (invalidDirection(direction)) {
            throw new IllegalArgumentException(error + Error.MOVE_DIRECTION_INVALID.getMessage());
        }
    }

    public static boolean invalidDirection(String direction) {
        return !(direction.equals(GameCommand.GO_UP.getGameCommand())
                || direction.equals(GameCommand.GO_DOWN.getGameCommand()));
    }

    public static void checkRestartCode(String code) {
        if (invalidRestartCode(code)) {
            throw new IllegalArgumentException(error + Error.RESTART_CODE_INVALID.getMessage());
        }
    }

    public static boolean invalidRestartCode(String code) {
        return !(code.equals(GameCommand.RESTART.getGameCommand()) || code.equals(GameCommand.QUIT.getGameCommand()));
    }

}
