package bridge.domain;

import bridge.constant.BridgeGameConstant;

public class Checker {
    private static final Checker checker = new Checker();
    private static final int MAXIMUM_BRIDGE_SIZE = 20;
    private static final int MINIMUM_BRIDGE_SIZE = 3;

    private Checker() {}

    public static Checker getInstance() {
        return checker;
    }

    public void validateBridgeSize(String bridgeSize) {
        try {
            if (!checkBridgeSizeRange(Integer.parseInt(bridgeSize))) {
                throw new IllegalArgumentException(InputExceptionMessage.WRONG_BRIDGE_SIZE.getMessage());
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(InputExceptionMessage.WRONG_BRIDGE_SIZE.getMessage());
        }
    }

    public void validateMoving(String moving) {
        if (!checkMovingValue(moving)) {
            throw new IllegalArgumentException(InputExceptionMessage.WRONG_MOVING.getMessage());
        }
    }

    public void validateGameCommand(String gameCommand) {
        if (!checkGameCommandValue(gameCommand)) {
            throw new IllegalArgumentException(InputExceptionMessage.WRONG_GAME_COMMAND.getMessage());
        }
    }

    private boolean checkBridgeSizeRange(int bridgeSize) {
        return MINIMUM_BRIDGE_SIZE <= bridgeSize && bridgeSize <= MAXIMUM_BRIDGE_SIZE;
    }

    private boolean checkMovingValue(String moving) {
        return moving.equals(Moving.UP.getValue()) || moving.equals(Moving.DOWN.getValue());
    }

    private boolean checkGameCommandValue(String gameCommand) {
        return gameCommand.equals(BridgeGameConstant.GAME_RESTART)
                || gameCommand.equals(BridgeGameConstant.GAME_QUIT);
    }
}
