package bridge;

import static bridge.ErrorMessage.BRIDGE_SIZE_NUMBER_ERROR_MESSAGE;
import static bridge.ErrorMessage.ERROR_MESSAGE;

public class ValidateInput {
    public static Integer isNumber(String number) {
        for (int i = 0; i < number.length(); i++) {
            if (!Character.isDigit(number.charAt(i))) {
                throw new IllegalArgumentException(ERROR_MESSAGE + BRIDGE_SIZE_NUMBER_ERROR_MESSAGE);
            }
        }
        return Integer.parseInt(number);
    }
}
