package view.validation;

import view.validation.exception.IllegalArgument;

public class InputViewValidation {

    public static void validateBridgeSizeInput(String sizeInput) {
        if (sizeInput.length() < 1 || sizeInput.length() > 2) {
            IllegalArgument.handleException(IllegalArgument.NOT_BRIDGE_INPUT.getMessage());
        }
        if (sizeInput.chars().allMatch(ch -> Character.isDigit(ch))) {
            return;
        }
        IllegalArgument.handleException(IllegalArgument.NOT_BRIDGE_INPUT.getMessage());
    }

    public static void validateBridgeSize(int size) {
        if (size < 3 || size > 20) {
            IllegalArgument.handleException(IllegalArgument.NOT_BRIDGE_INPUT.getMessage());
        }
    }

    public static void validateMovingInput(String movingInput) {
        if (movingInput.equals("U") || (movingInput.equals("D"))) {
            return;
        }
        IllegalArgument.handleException(IllegalArgument.NOT_MOVING_INPUT.getMessage());
    }

    public static void validateCommandInput(String commandInput){
        if (commandInput.equals("R") || (commandInput.equals("Q"))) {
            return;
        }
        IllegalArgument.handleException(IllegalArgument.NOT_MOVING_INPUT.getMessage());

    }


}
