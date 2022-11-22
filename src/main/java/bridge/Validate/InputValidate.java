package bridge.validate;

import bridge.message.Error;

public class InputValidate {
    private static final int MIN_BRIDGE_SIZE = 3;
    private static final int MAX_BRIDGE_SIZE = 20;

    public void validateCharacter(String input) {
        for (char c : input.toCharArray()) {
            if (!Character.isDigit(c)) {
                throw new IllegalArgumentException(Error.WRONG_BRIDGE_NUMBER);
            }
        }
    }

    public void validateInputRange(String input) {
        int size = Integer.parseInt(input);
        if (size < MIN_BRIDGE_SIZE || size > MAX_BRIDGE_SIZE) {
            throw new IllegalArgumentException(Error.WRONG_BRIDGE_NUMBER);
        }
    }

    public void validateInputEmpty(String input) {
        if (input.equals("")) {
            throw new IllegalArgumentException(Error.WRONG_BRIDGE_NUMBER);
        }
    }

    public void validateMoving(String direction) {
        if (!direction.equals("U") && !direction.equals("D")) {
            throw new IllegalArgumentException(Error.WRONG_INPUT);
        }
    }

    public void validateRetry(String retry) {
        if (!retry.equals("R") && !retry.equals("Q")) {
            throw new IllegalArgumentException(Error.WRONG_INPUT);
        }
    }
}