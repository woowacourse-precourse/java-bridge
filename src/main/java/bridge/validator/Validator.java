package bridge.validator;

import bridge.view.Messages;

public class Validator {

    public void validateInputIsNumber(String userInput) {
        for (char input : userInput.toCharArray()) {
            if (!Character.isDigit(input)) {
                throw new IllegalArgumentException(Messages.ERROR_INPUT_NUMBER.getMessage());
            }
        }
    }

    public void validateBridgeSize(String userInput) {
        validateInputIsNumber(userInput);

        int bridgeSize = StringToInteger(userInput);

        if (bridgeSize < Unit.BRIDGE_MINIMUM_SIZE.getSize() || bridgeSize > Unit.BRIDGE_MAXIMUM_SIZE.getSize()) {
            throw new IllegalArgumentException(Messages.ERROR_BRIDGE_SIZE.getMessage());
        }
    }

    public void validateMove(String userInput) {
        if (!(userInput.equals(Unit.UP.getCommand()) || userInput.equals(Unit.DOWN.getCommand()))) {
            throw new IllegalArgumentException(Messages.ERROR_MOVE.getMessage());
        }
    }

    public void validateGameCommand(String userInput) {
        if (!(userInput.equals(Unit.RETRY.getCommand()) || userInput.equals(Unit.QUITE.getCommand()))) {
            throw new IllegalArgumentException(Messages.ERROR_GAME_COMMAND.getMessage());
        }
    }

    public int StringToInteger(String userInput) {
        return Integer.parseInt(userInput);
    }
}
