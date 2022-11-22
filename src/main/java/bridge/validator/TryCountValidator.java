package bridge.validator;

import bridge.constants.ValidatorMessage;

public class TryCountValidator {
    private static final int MAX_TRY_COUNT = 2100000000;

    public static void validateTryCount(int tryCount) {
        if (MAX_TRY_COUNT <= tryCount) {
            throw new IllegalArgumentException(ValidatorMessage.TOO_MUCH_GAME.toString());
        }
    }
}
