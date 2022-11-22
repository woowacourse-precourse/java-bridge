package bridge;

import static bridge.constant.ErrorConstant.ERROR_NON_INTEGER;

public class InputViewValidation {

    public static void isDigitInput(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (!Character.isDigit(input.charAt(i))) {
                throw new IllegalArgumentException(ERROR_NON_INTEGER);
            }
        }
    }
}
