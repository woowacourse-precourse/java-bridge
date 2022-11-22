package bridge;

import java.util.Arrays;
import java.util.List;

public class Validator {

    private final int BRIDGE_MIN_SIZE = 3;
    private final int BRIDGE_MAX_SIZE = 20;
    private final int INPUT_SIZE = 1;
    private final List<String> MOVING_VALUES = Arrays.asList("U", "D");
    private final List<String> COMMAND_VALUES = Arrays.asList("R", "Q");

    public void validateBridgeSize(int size) {
        if (size < BRIDGE_MIN_SIZE || size > BRIDGE_MAX_SIZE) {
            throw new IllegalArgumentException(Error.BRIDGE_OUT_OF_RANGE.getMessage());
        }
    }

    private boolean isValidInput(List<String> values, String input) {
        int index = values.indexOf(input);
        return !(input.length() > INPUT_SIZE || index == -1);
    }

    public void validateCommand(String command) {
        if (!isValidInput(COMMAND_VALUES, command)) {
            throw new IllegalArgumentException(Error.INVALID_COMMAND.getMessage());
        }
    }

    public void validateMoving(String moving) {
        if (!isValidInput(MOVING_VALUES, moving)) {
            throw new IllegalArgumentException(Error.INVALID_MOVING.getMessage());
        }
    }
}
