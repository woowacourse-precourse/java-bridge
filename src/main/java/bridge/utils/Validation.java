package bridge.utils;

import bridge.constant.ErrorStatus;
import bridge.constant.GameKeyboard;

import static bridge.constant.GameKeyboard.*;

public class Validation {

    public static final int MINIMUM_BRIDGE_SIZE = 3;
    public static final int MAXIMUM_BRIDGE_SIZE = 20;

    public static int validateBridgeSize(String bridgeSize) {
        int bridgeSizeNumber = validateNumber(bridgeSize);
        return validateSize(bridgeSizeNumber);
    }

    private static int validateSize(int bridgeSizeNumber) {
        if (bridgeSizeNumber < MINIMUM_BRIDGE_SIZE || bridgeSizeNumber > MAXIMUM_BRIDGE_SIZE) {
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
        if (isNotMatchMovingLetter(moving, UP, DOWN)) {
            throw new IllegalArgumentException(ErrorStatus.WRONG_MOVING_LETTER.getMessage());
        }
        return moving;
    }

    private static boolean isNotMatchMovingLetter(String moving, GameKeyboard up, GameKeyboard down) {
        return !(moving.equals(up.letter()) || moving.equals(down.letter()));
    }

    public static String validateRestartInput(String restartAnswer) {
        if (isNotMatchRestartLetter(restartAnswer, RESTART, QUIT)) {
            throw new IllegalArgumentException(ErrorStatus.WRONG_RESTART_LETTER.getMessage());
        }
        return restartAnswer;
    }

    private static boolean isNotMatchRestartLetter(String restartAnswer, GameKeyboard restart, GameKeyboard quit) {
        return !(restartAnswer.equals(restart.letter()) || restartAnswer.equals(quit.letter()));
    }
}
