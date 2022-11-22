package bridge.utils;

import bridge.Enum.Error;
import bridge.Enum.Number;
import bridge.Enum.PlayerInput;

public class InputValidator {
    private void isEmpty(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException(Error.INPUT_BLANK.getMessage());
        }
    }

    private Integer isInteger(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Error.BRIDGE_SIZE.getMessage());
        }
    }

    private void isNumberInRange(int number) {
        if ((number > Number.MAX.getValue() || number < Number.MIN.getValue())) {
            throw new IllegalArgumentException(Error.BRIDGE_SIZE.getMessage());
        }
    }

    public void isDirectionValid(String direction) {
        if (!direction.equals(PlayerInput.DOWN) && !direction.equals(PlayerInput.DOWN)) {
            throw new IllegalArgumentException(Error.INPUT_DIRECTION.getMessage());
        }
    }

    public void isRetryValid(String decision) {
        if (!decision.equals(PlayerInput.RESTART) && !decision.equals(PlayerInput.QUIT)) {
            throw new IllegalArgumentException(Error.INPUT_CONTINUE.getMessage());
        }
    }
}
