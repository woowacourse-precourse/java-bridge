package bridge.controller;

import bridge.util.InputValidator;
import bridge.view.InputView;

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
        try {
            InputValidator.validateBridgeSizeRange(toInt(bridgeSize));
        } catch (RuntimeException exception) {
            System.out.println(exception.getMessage());
            return checkBridgeSize(InputView.readBridgeSize());
        }
        return toInt(bridgeSize);
    }

    private String checkMoving(String moving) throws RuntimeException {
        try {
            InputValidator.validateMoving(moving);
        } catch (RuntimeException exception) {
            System.out.println(exception.getMessage());
            return checkMoving(InputView.readMoving());
        }
        return moving;
    }

    private String checkGameCommand(String gameCommand) throws RuntimeException {
        try {
            InputValidator.validateGameCommand(gameCommand);
        } catch (RuntimeException exception) {
            System.out.println(exception.getMessage());
            return checkGameCommand(InputView.readGameCommand());
        }
        return gameCommand;
    }
}
