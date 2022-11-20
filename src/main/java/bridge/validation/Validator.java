package bridge.validation;

import bridge.type.CommandType;
import bridge.type.Direction;
import bridge.type.ErrorMessage;
import bridge.type.NumberType;

public class Validator {

    public void checkBridgeSize(String input) {
        isNumeric(input);
        isCorrectBoundary(input);
    }

    public void isNumeric(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.BRIDGE_SIZE_NUMERIC.getMessage());
        }
    }

    public void isCorrectBoundary(String bridgeSizeInput) {
        int bridgeSize = Integer.parseInt(bridgeSizeInput);
        if (bridgeSize < NumberType.BRIDGE_MIN_LENGTH.getNumber() || bridgeSize > NumberType.BRIDGE_MAX_LENGTH.getNumber()) {
            throw new IllegalArgumentException(ErrorMessage.BRIDGE_SIZE_BOUNDARY.getMessage());
        }
    }

    public void checkDirection(String input) {
        if (input.equals(Direction.UP.getLetter()) || input.equals(Direction.DOWN.getLetter())) {
            return;
        }
        throw new IllegalArgumentException(ErrorMessage.WRONG_DIRECTION.getMessage());
    }

    public void checkCommand(String input) {
        if (input.equals(CommandType.QUIT.getCommand()) || input.equals(CommandType.RETRY.getCommand())) {
            return;
        }
        throw new IllegalArgumentException(ErrorMessage.WRONG_COMMAND.getMessage());
    }
}
