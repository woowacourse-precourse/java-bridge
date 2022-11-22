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

    public static String checkEmptyInput(String input) {
        if (input.equals("")) {
            throw new IllegalArgumentException(ERROR_MESSAGE + EMPTY_INPUT_ERROR_MESSAGE);
        }
        return input;
    }

    public static String checkSpaceToMove(String space) {
        if (space.equals("U") || space.equals("D")) {
            return space;
        }
        throw new IllegalArgumentException(ERROR_MESSAGE + SPACE_TO_MOVE_ERROR_MESSAGE);
    }
}
