package util;

import constant.ErrorMessage;
import constant.NumberConstant;
import constant.StringConstant;

public class MovingValidator {

    public static void isValid(String moving) {
        isOneLetter(moving);
        isEqualsUOrD(moving);
    }

    private static void isOneLetter(String moving) {
        if (moving.length() != NumberConstant.ONE_LETTER.getConstant()) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_LENGTH.getErrorMessage());
        }
    }

    private static void isEqualsUOrD(String moving) {
        if (!moving.equals(StringConstant.UP_SIDE.getConstant())
                && !moving.equals(StringConstant.DOWN_SIDE.getConstant())) {
            throw new IllegalArgumentException(ErrorMessage.MOVE_INVALID.getErrorMessage());
        }
    }
}
