package bridge.exception;

import bridge.util.Constants.Constant;

public class IllegalArgument {

    public static boolean isNotNumber(String numberInput) {
        if (numberInput.matches(Constant.CHECK_NUMBER_ONLY)) {
            return false;
        }
        return true;
    }

    public static boolean isNotInBridgeSizeRange(String bridgeSizeInput) {
        if (Integer.parseInt(bridgeSizeInput) < Constant.BRIDGE_SIZE_MIN ||
                Integer.parseInt(bridgeSizeInput) > Constant.BRIDGE_SIZE_MAX) {
            return true;
        }
        return false;
    }

    public static boolean isIncorrectMoving(String moving) {
        if (moving.equals(Constant.UPSIDE) || moving.equals(Constant.DOWN)) {
            return false;
        }
        return true;
    }

    public static boolean isIncorrectGameCommand(String gameCommand) {
        if (gameCommand.equals(Constant.RESTART) || gameCommand.equals(Constant.QUIT)) {
            return false;
        }
        return true;
    }
}
