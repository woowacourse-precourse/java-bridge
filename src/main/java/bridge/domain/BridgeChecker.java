package bridge.domain;

import bridge.constant.enums.Moving;
import bridge.constant.Message.InputExceptionMessage;
import bridge.constant.Bridge.GameConstants;
import bridge.constant.Bridge.Checker;

public class BridgeChecker {
    private static final BridgeChecker checker = new BridgeChecker();

    private BridgeChecker() {}

    public static BridgeChecker getInstance() {
        return checker;
    }

    public void validateBridgeSize(String bridgeSize) {
        try {
            if (!checkBridgeSizeRange(Integer.parseInt(bridgeSize))) {
                throw new IllegalArgumentException(InputExceptionMessage.WRONG_BRIDGE_SIZE);
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(InputExceptionMessage.WRONG_BRIDGE_SIZE);
        }
    }

    public void validateMoving(String moving) {
        if (!checkMovingValue(moving)) {
            throw new IllegalArgumentException(InputExceptionMessage.WRONG_MOVING);
        }
    }

    public void validateGameCommand(String gameCommand) {
        if (!checkGameCommandValue(gameCommand)) {
            throw new IllegalArgumentException(InputExceptionMessage.WRONG_GAME_COMMAND);
        }
    }

    private boolean checkBridgeSizeRange(int bridgeSize) {
        return Checker.MINIMUM_BRIDGE_SIZE <= bridgeSize && bridgeSize <= Checker.MAXIMUM_BRIDGE_SIZE;
    }

    private boolean checkMovingValue(String moving) {
        return moving.equals(Moving.UP.getValue()) || moving.equals(Moving.DOWN.getValue());
    }

    private boolean checkGameCommandValue(String gameCommand) {
        return gameCommand.equals(GameConstants.GAME_RETRY)
                || gameCommand.equals(GameConstants.GAME_QUIT);
    }
}
