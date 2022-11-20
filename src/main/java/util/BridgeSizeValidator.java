package util;

import constant.ErrorMessage;
import constant.NumberConstant;
import constant.StringConstant;

public class BridgeSizeValidator {

    public static void isValid(String size) {
        isOneOrTwoLetters(size);
        isComponentNumber(size);
        isValidRange(Converter.convertStringToInt(size));
    }

    private static void isComponentNumber(String size) {
        if (!size.matches(StringConstant.BRIDGE_SIZE_REGEX.getConstant())) {
            throw new IllegalArgumentException(ErrorMessage.BRIDGE_SIZE_INVALID_RANGE.getErrorMessage());
        }
    }

    private static void isValidRange(int size) {
        if (NumberConstant.BRIDGE_SIZE_START_INCLUSIVE.getConstant() > size
                || size > NumberConstant.BRIDGE_SIZE_END_INCLUSIVE.getConstant()) {
            throw new IllegalArgumentException(ErrorMessage.BRIDGE_SIZE_INVALID_RANGE.getErrorMessage());
        }
    }

    private static void isOneOrTwoLetters(String moving) {
        if (moving.length() != NumberConstant.ONE_LETTER.getConstant()
                && moving.length() != NumberConstant.TWO_LETTERS.getConstant()) {
            throw new IllegalArgumentException(ErrorMessage.BRIDGE_SIZE_INVALID_RANGE.getErrorMessage());
        }
    }

}
