package util.validator;

import constant.ErrorConstant;
import constant.InputConstant;
import constant.NumberConstant;

public class GameCommandValidator {
    public static void isValid(String gameCommand) {
        isOneLetter(gameCommand);
        isEqualsRorQ(gameCommand);
    }

    private static void isOneLetter(String moving) {
        if (moving.length() != NumberConstant.ONE_LETTER.getConstant()) {
            throw new IllegalArgumentException(ErrorConstant.INPUT_LENGTH.getConstant());
        }
    }

    private static void isEqualsRorQ(String gameCommand) {
        if (!gameCommand.equals(InputConstant.QUIT.getConstant())
                && !gameCommand.equals(InputConstant.RETRY.getConstant())) {
            throw new IllegalArgumentException(ErrorConstant.RETRY_OR_QUIT_INVALID.getConstant());
        }
    }
}
