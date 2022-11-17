package bridge.utils;

import bridge.ErrorStatus;

public class Validation {
    public static int validateBridgeSize(String bridgeSize) {
        int bridgeSizeNumber = validateNumber(bridgeSize);
        return validateSize(bridgeSizeNumber);
    }

    private static int validateSize(int bridgeSizeNumber) {
        if (bridgeSizeNumber < 3 || bridgeSizeNumber > 20) {
            throw new IllegalArgumentException(ErrorStatus.BRIDGE_SIZE_OUT_RANGE.getMessage());
        }
        return bridgeSizeNumber;
    }

    private static int validateNumber(String bridgeSize) {
        try {
            Integer.parseInt(bridgeSize);
        } catch (NumberFormatException error) {
            throw new IllegalArgumentException(ErrorStatus.BRIDGE_NOT_NUMBER.getMessage());
        }
        return Integer.parseInt(bridgeSize);
    }

    public static String validateMoving(String moving) {
        if (!(moving.equals("U") || moving.equals("D"))) {
            throw new IllegalArgumentException(ErrorStatus.WRONG_MOVING_LETTER.getMessage());
        }
        return moving;
    }

    public static String validateRestartInput(String restartAnswer) {
        if (!(restartAnswer.equals("R") || restartAnswer.equals("Q"))) {
            throw new IllegalArgumentException(ErrorStatus.WRONG_RESTART_LETTER.getMessage());
        }
        return restartAnswer;
    }
}
