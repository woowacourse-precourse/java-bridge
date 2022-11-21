package utils;

import bridge.type.DirectionType;
import bridge.type.GameOptionType;

public class IllegalInputChecker {
    private static final String BRIDGE_SIZE = "^\\d{1,2}$";
    private static final String MOVE_INPUT = "^[UD]$";
    private static final String GAME_OPTION = "^[RQ]$";

    public static int checkBridgeSizeInput(String bridgeSize) {
        isBridgeSizeNumeric(bridgeSize);
        return isNumOfBridgeSizeValid(bridgeSize);
    }

    public static String checkMoveInput(String moveInput) {
        if (!moveInput.matches(MOVE_INPUT)) {
            throw new IllegalArgumentException(ExceptionMessage.MOVE_INPUT_INVALID);
        }
        return moveInput;
    }

    public static GameOptionType checkRestartOrQuit(String option) {
        if (!option.matches(GAME_OPTION)) {
            throw new IllegalArgumentException(ExceptionMessage.GAME_OPTION_INVALID);
        }
        return GameOptionType.valueOf(option);
    }

    public static void isBridgeSizeNumeric (String bridgeSize) {
        if (!bridgeSize.matches(BRIDGE_SIZE)) {
            throw new IllegalArgumentException(ExceptionMessage.BRIDGE_SIZE_NOT_NUMERIC);
        }
    }

    public static int isNumOfBridgeSizeValid (String bridgeSize) {
        if (Integer.parseInt(bridgeSize) < 3 || Integer.parseInt(bridgeSize) > 20) {
            throw new IllegalArgumentException(ExceptionMessage.BRIDGE_SIZE_NUM_INVALID);
        }
        return Integer.parseInt(bridgeSize);
    }

}
