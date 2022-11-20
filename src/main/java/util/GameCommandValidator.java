package util;

import constant.ErrorMessage;
import constant.NumberConstant;
import constant.StringConstant;

public class GameCommandValidator {
    public static void isValid(String gameCommand) {
        isOneLetter(gameCommand);
        isEqualsRorQ(gameCommand);
    }

    private static void isOneLetter(String moving) {
        if (moving.length() != NumberConstant.ONE_LETTER.getConstant()) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_LENGTH.getErrorMessage());
        }
    }

    private static void isEqualsRorQ(String gameCommand) {
        if (!gameCommand.equals(StringConstant.QUIT.getConstant())
                && !gameCommand.equals(StringConstant.RETRY.getConstant())) {
            throw new IllegalArgumentException(ErrorMessage.RETRY_OR_QUIT_INVALID.getErrorMessage());
        }
    }
}
