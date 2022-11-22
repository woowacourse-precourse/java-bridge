package bridge.view;

import bridge.constants.ErrorCode;

public class ViewValidator {
    public static void isNumber(String input) {
        if (input.chars().allMatch(Character::isDigit)) {
            return;
        }

        ErrorCode.ERROR_NOT_NUMBER.throwIllegalArgumentException();
    }

    public static void isNotEmptyOrNull(String input) {
        if (input == null || input.isEmpty()) {

            ErrorCode.ERROR_ULL_OR_EMPTY.throwIllegalArgumentException();
        }
    }
}
