package util.validator;

import constant.ErrorConstant;
import constant.InputConstant;
import constant.NumberConstant;

public class GameCommandValidator {
    private static final int ONE_LETTER = NumberConstant.ONE_LETTER.getConstant();
    private static final String QUIT = InputConstant.QUIT.getConstant();
    private static final String RETRY = InputConstant.RETRY.getConstant();
    private static final String INPUT_LENGTH = ErrorConstant.INPUT_LENGTH.getConstant();
    private static final String RETRY_OR_QUIT_INVALID = ErrorConstant.RETRY_OR_QUIT_INVALID.getConstant();

    public static void isValid(String gameCommand) {
        isOneLetter(gameCommand);
        isEqualsRorQ(gameCommand);
    }

    private static void isOneLetter(String moving) {
        if (moving.length() != ONE_LETTER) {
            throw new IllegalArgumentException(INPUT_LENGTH);
        }
    }

    private static void isEqualsRorQ(String gameCommand) {
        if (!gameCommand.equals(QUIT) && !gameCommand.equals(RETRY)) {
            throw new IllegalArgumentException(RETRY_OR_QUIT_INVALID);
        }
    }
}
