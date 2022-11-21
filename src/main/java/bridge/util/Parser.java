package bridge.util;

import bridge.exception.IllegalArgument;
import bridge.util.Constants.ErrorMessage;

public class Parser {

    public int parseBridgeSize(String bridgeSizeInput) {
        if (IllegalArgument.isNotNumber(bridgeSizeInput) || IllegalArgument.isNotInBridgeSizeRange(bridgeSizeInput)) {
            throw new IllegalArgumentException(ErrorMessage.BRIDGE_SIZE_ERROR);
        }
        return Integer.parseInt(bridgeSizeInput);
    }

    public String parseMoving(String moving) {
        if (IllegalArgument.isIncorrectMoving(moving)) {
            throw new IllegalArgumentException(ErrorMessage.INCORRECT_MOVING_ERROR);
        }
        return moving;
    }

    public String parsingGameCommand(String gameCommand) {
        if (IllegalArgument.isIncorrectGameCommand(gameCommand)) {
            throw new IllegalArgumentException(ErrorMessage.INCORRECT_GAME_COMMAND_ERROR);
        }
        return gameCommand;
    }
}
