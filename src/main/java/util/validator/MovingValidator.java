package util.validator;

import constant.ErrorConstant;
import constant.InputConstant;
import constant.NumberConstant;

public class MovingValidator {
    public static void isValid(String moving) {
        isOneLetter(moving);
        isEqualsUOrD(moving);
    }

    private static void isOneLetter(String moving) {
        if (moving.length() != NumberConstant.ONE_LETTER.getConstant()) {
            throw new IllegalArgumentException(ErrorConstant.INPUT_LENGTH.getConstant());
        }
    }

    private static void isEqualsUOrD(String moving) {
        if (!moving.equals(InputConstant.UP_SIDE.getConstant())
                && !moving.equals(InputConstant.DOWN_SIDE.getConstant())) {
            throw new IllegalArgumentException(ErrorConstant.MOVE_INVALID.getConstant());
        }
    }
}
