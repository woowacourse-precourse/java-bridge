package util.validator;

import constant.ErrorConstant;
import constant.InputConstant;
import constant.NumberConstant;

public class MovingValidator {
    private static final int ONE_LETTER = NumberConstant.ONE_LETTER.getConstant();
    private static final String UP_SIDE = InputConstant.UP_SIDE.getConstant();
    private static final String DOWN_SIDE = InputConstant.DOWN_SIDE.getConstant();
    private static final String INPUT_LENGTH = ErrorConstant.INPUT_LENGTH.getConstant();
    private static final String MOVE_INVALID = ErrorConstant.MOVE_INVALID.getConstant();

    public static void isValid(String moving) {
        isOneLetter(moving);
        isEqualsUOrD(moving);
    }

    private static void isOneLetter(String moving) {
        if (moving.length() != ONE_LETTER) {
            throw new IllegalArgumentException(INPUT_LENGTH);
        }
    }

    private static void isEqualsUOrD(String moving) {
        if (!moving.equals(UP_SIDE) && !moving.equals(DOWN_SIDE)) {
            throw new IllegalArgumentException(MOVE_INVALID);
        }
    }
}
