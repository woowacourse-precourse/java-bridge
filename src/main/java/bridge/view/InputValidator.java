package bridge.view;

import bridge.BridgeShape;
import bridge.Command;
import bridge.Error;

public class InputValidator {

    private static final int MINIMUM_BRIDGE_SIZE = 3;
    private static final int MAXIMUM_BRIDGE_SIZE = 20;

    public void validateBridgeSize(String bridgeSize) throws IllegalArgumentException {
        if (!isNumeric(bridgeSize)) {
            throw new IllegalArgumentException(Error.IS_WRONG_BRIDGE_SIZE.getMessage());
        }

        if (!isPossibleSize(Integer.parseInt(bridgeSize))) {
            throw new IllegalArgumentException(Error.IS_WRONG_BRIDGE_SIZE.getMessage());
        }
    }

    public void validateMoving(String moving) throws IllegalArgumentException {
        if (!isPossibleMoving(moving)) {
            throw new IllegalArgumentException(Error.IS_NOT_POSSIBLE_MOVING.getMessage());
        }
    }

    public void validateGameCommand(String gameCommand) throws IllegalArgumentException {
        if (!isCommand(gameCommand)) {
            throw new IllegalArgumentException(Error.IS_WRONG_COMMAND.getMessage());
        }
    }

    private boolean isNumeric(String string) {
        return string.chars()
            .allMatch(Character::isDigit);
    }

    private boolean isPossibleSize(int size) {
        return size >= MINIMUM_BRIDGE_SIZE && size <= MAXIMUM_BRIDGE_SIZE;
    }

    private boolean isPossibleMoving(String moving) {
        return BridgeShape.contains(moving);
    }

    private boolean isCommand(String command) {
        return Command.contains(command);
    }
}
