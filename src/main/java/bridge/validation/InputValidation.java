package bridge.validation;

import static bridge.constant.BridgeConstant.COMMAND_INPUT_REGEX;
import static bridge.constant.BridgeConstant.DIRECTION_INPUT_REGEX;
import static bridge.constant.BridgeConstant.MAX_BRIDGE_LENGTH;
import static bridge.constant.BridgeConstant.MIN_BRIDGE_LENGTH;
import static bridge.constant.BridgeErrorMessage.BRIDGE_LENGTH_IS_NOT_DIGIT_ERROR_MESSAGE;
import static bridge.constant.BridgeErrorMessage.BRIDGE_LENGTH_IS_NOT_IN_RANGE_ERROR_MESSAGE;
import static bridge.constant.BridgeErrorMessage.COMMAND_IS_NOT_VALID_ERROR_MESSAGE;
import static bridge.constant.BridgeErrorMessage.DIRECTION_IS_NOT_VALID_ERROR_MESSAGE;

public class InputValidation {

    public InputValidation() {
    }

    public int getValue(String input) throws IllegalArgumentException {
        if (!input.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException(BRIDGE_LENGTH_IS_NOT_DIGIT_ERROR_MESSAGE);
        }

        int inputValue = Integer.parseInt(input);
        if (inputValue < MIN_BRIDGE_LENGTH || inputValue > MAX_BRIDGE_LENGTH) {
            throw new IllegalArgumentException(BRIDGE_LENGTH_IS_NOT_IN_RANGE_ERROR_MESSAGE);
        }

        return inputValue;
    }

    public String getDirections(String input) throws IllegalArgumentException {
        if (!input.matches(DIRECTION_INPUT_REGEX)) {
            throw new IllegalArgumentException(DIRECTION_IS_NOT_VALID_ERROR_MESSAGE);
        }
        return input;
    }

    public String getCommand(String command) throws IllegalArgumentException {
        if (!command.matches(COMMAND_INPUT_REGEX)) {
            throw new IllegalArgumentException(COMMAND_IS_NOT_VALID_ERROR_MESSAGE);
        }
        return command;
    }
}
