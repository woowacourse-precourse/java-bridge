package view.validation;

import constants.BridgeConstant;
import constants.CommandTable;
import constants.DirectionTable;
import exception.IllegalArgument;

public class InputViewValidation {
    public static void validateBridgeSizeInput(String sizeInput) {
        int length = sizeInput.length();

        if (length < BridgeConstant.MIN_SIZE_INPUT_LENGTH || length > BridgeConstant.MAX_SIZE_INPUT_LENGTH) {
            IllegalArgument.handleException(IllegalArgument.NOT_BRIDGE_INPUT.getMessage());
        }
        if (sizeInput.chars().allMatch(ch -> Character.isDigit(ch))) {
            return;
        }
        IllegalArgument.handleException(IllegalArgument.NOT_BRIDGE_INPUT.getMessage());
    }

    public static void validateBridgeSize(int size) {
        if (size < BridgeConstant.MIN_BRIDGE_SIZE || size > BridgeConstant.MAX_BRIDGE_SIZE) {
            IllegalArgument.handleException(IllegalArgument.NOT_BRIDGE_INPUT.getMessage());
        }
    }

    public static void validateMovingInput(String movingInput) {
        if (movingInput.equals(DirectionTable.UP.getInitial())) {
            return;
        }
        if (movingInput.equals(DirectionTable.DOWN.getInitial())) {
            return;
        }
        IllegalArgument.handleException(IllegalArgument.NOT_MOVING_INPUT.getMessage());
    }

    public static void validateCommandInput(String commandInput) {
        if (commandInput.equals(CommandTable.RETRY.getInitial())) {
            return;
        }
        if (commandInput.equals(CommandTable.QUIT.getInitial())) {
            return;
        }
        IllegalArgument.handleException(IllegalArgument.NOT_COMMAND_INPUT.getMessage());
    }
}
