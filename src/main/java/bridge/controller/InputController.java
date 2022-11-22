package bridge.controller;

import bridge.util.InputValidator;

public class InputController {

    public int getBridgeSize(String bridgeSize) throws RuntimeException {
        return checkBridgeSize(bridgeSize);
    }

    public String getMoving(String moving) throws RuntimeException {
        return checkMoving(moving);
    }

    public String getGameCommand(String gameCommand) throws RuntimeException {
        return checkGameCommand(gameCommand);
    }

    private int toInt(String bridgeSize) throws RuntimeException {
        InputValidator.validateBridgeSize(bridgeSize);
        return Integer.parseInt(bridgeSize);
    }

    private int checkBridgeSize(String bridgeSize) throws RuntimeException {
        InputValidator.validateBridgeSizeRange(toInt(bridgeSize));
        return toInt(bridgeSize);
    }

    private String checkMoving(String moving) throws RuntimeException {
        InputValidator.validateMoving(moving);
        return moving;
    }

    private String checkGameCommand(String gameCommand) throws RuntimeException {
        InputValidator.validateGameCommand(gameCommand);
        return gameCommand;
    }
}
