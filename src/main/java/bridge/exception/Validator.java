package bridge.exception;

import bridge.domain.BridgeLength;
import bridge.domain.GameCommand;
import bridge.domain.Moving;

public class Validator {

    public static void validBridgeLength(int bridgeLength) {
        if (bridgeLength < BridgeLength.MIN.getSize() || bridgeLength > BridgeLength.MAX.getSize()) {
            throw new IllegalArgumentException(Error.WRONG_BRIDGE_LENGTH.getMessage());
        }
    }

    public static void validMoving(String movingExpression) {
        if (Moving.findByExpression(movingExpression).isEmpty()) {
            throw new IllegalArgumentException(Error.WRONG_MOVING.getMessage());
        }
    }

    public static void validGameCommand(String gameCommandExpression) {
        if (GameCommand.findByExpression(gameCommandExpression).isEmpty()) {
            throw new IllegalArgumentException(Error.WRONG_GAME_COMMAND.getMessage());
        }
    }
}