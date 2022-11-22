package bridge;

import bridge.enums.InputExceptionConstants;

public class Validator {

    public void isNumeric(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(InputExceptionConstants.NONE_NUMERIC.getMessage());
        }
    }

    public void isInRange(int input) {
        if (input < 3 || input > 20) {
            throw new IllegalArgumentException(InputExceptionConstants.BRIDGE_RANGE.getMessage());
        }
    }


}
