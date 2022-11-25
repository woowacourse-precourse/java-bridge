package bridge.validation;

import bridge.constants.ValidatorMessage;

public class NumberOfTryValidator {

    private static final int MAX_NUMBER_OF_TRY = 2100000000;

    public static void validateNumberOfTry(int tryCount) {
        if (MAX_NUMBER_OF_TRY <= tryCount) {
            throw new IllegalArgumentException(ValidatorMessage.TOO_MUCH_GAME.toString());
        }
    }
}
