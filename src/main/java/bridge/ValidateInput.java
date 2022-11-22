package bridge;

import static bridge.ErrorMessage.*;

public class ValidateInput {
    public static Integer isNumber(String number) {
        for (int i = 0; i < number.length(); i++) {
            if (!Character.isDigit(number.charAt(i))) {
                throw new IllegalArgumentException(ERROR_MESSAGE + BRIDGE_SIZE_NUMBER_ERROR_MESSAGE);
            }
        }
        return Integer.parseInt(number);
    }

    public static Integer checkBridgeSizeRange(int number) {
        if (number >= 3 && number <= 20) {
            return number;
        }
        throw new IllegalArgumentException(ERROR_MESSAGE + BRIDGE_SIZE_RANGE_ERROR_MESSAGE);
    }
}
