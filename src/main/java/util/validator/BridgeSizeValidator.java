package util.validator;

import constant.BridgeConstant;
import constant.BridgeRegexConstant;
import constant.ErrorConstant;
import constant.NumberConstant;
import util.ConverterUtil;

public class BridgeSizeValidator {

    public static void isValid(String size) {
        isOneOrTwoLetters(size);
        isComponentNumber(size);
        isValidRange(ConverterUtil.convertStringToInt(size));
    }

    private static void isComponentNumber(String size) {
        if (!size.matches(BridgeRegexConstant.BRIDGE_SIZE_REGEX.getConstant())) {
            throw new IllegalArgumentException(ErrorConstant.BRIDGE_SIZE_INVALID_RANGE.getConstant());
        }
    }

    private static void isValidRange(int size) {
        if (BridgeConstant.BRIDGE_SIZE_START_INCLUSIVE.getConstant() > size
                || size > BridgeConstant.BRIDGE_SIZE_END_INCLUSIVE.getConstant()) {
            throw new IllegalArgumentException(ErrorConstant.BRIDGE_SIZE_INVALID_RANGE.getConstant());
        }
    }

    private static void isOneOrTwoLetters(String moving) {
        if (moving.length() != NumberConstant.ONE_LETTER.getConstant()
                && moving.length() != NumberConstant.TWO_LETTERS.getConstant()) {
            throw new IllegalArgumentException(ErrorConstant.BRIDGE_SIZE_INVALID_RANGE.getConstant());
        }
    }

}
