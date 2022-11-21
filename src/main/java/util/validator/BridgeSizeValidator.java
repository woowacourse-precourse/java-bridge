package util.validator;

import constant.BridgeConstant;
import constant.BridgeRegexConstant;
import constant.ErrorConstant;
import constant.NumberConstant;
import util.ConverterUtil;

public class BridgeSizeValidator {
    private static final int ONE_LETTER = NumberConstant.ONE_LETTER.getConstant();
    private static final int TWO_LETTERS = NumberConstant.TWO_LETTERS.getConstant();
    private static final int BRIDGE_SIZE_START_INCLUSIVE = BridgeConstant.BRIDGE_SIZE_START_INCLUSIVE.getConstant();
    private static final int BRIDGE_SIZE_END_INCLUSIVE = BridgeConstant.BRIDGE_SIZE_END_INCLUSIVE.getConstant();
    private static final String BRIDGE_SIZE_REGEX = BridgeRegexConstant.BRIDGE_SIZE_REGEX.getConstant();
    private static final String BRIDGE_SIZE_INVALID_RANGE = ErrorConstant.BRIDGE_SIZE_INVALID_RANGE.getConstant();


    public static void isValid(String size) {
        isOneOrTwoLetters(size);
        isComponentNumber(size);
        isValidRange(ConverterUtil.convertStringToInt(size));
    }

    private static void isComponentNumber(String size) {
        if (!size.matches(BRIDGE_SIZE_REGEX)) {
            throw new IllegalArgumentException(BRIDGE_SIZE_INVALID_RANGE);
        }
    }

    private static void isValidRange(int size) {
        if (BRIDGE_SIZE_START_INCLUSIVE > size || size > BRIDGE_SIZE_END_INCLUSIVE) {
            throw new IllegalArgumentException(BRIDGE_SIZE_INVALID_RANGE);
        }
    }

    private static void isOneOrTwoLetters(String moving) {
        if (moving.length() != ONE_LETTER && moving.length() != TWO_LETTERS) {
            throw new IllegalArgumentException();
        }
    }

}
