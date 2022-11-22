package bridge.controller;

import bridge.model.InputValidator;
import bridge.view.InputView;

public class InputController {

    InputView inputView = new InputView();
    InputValidator inputValidator = new InputValidator();

    public int inputBridgeSize() {
        try {
            int bridgeSize = inputView.readBridgeSize();
            inputValidator.BridgeSize(bridgeSize);
            return bridgeSize;
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return inputBridgeSize();
        }
    }

    public String inputMoving() {
        try {
            String moving = inputView.readMoving();
            inputValidator.Moving(moving);
            return moving;
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return inputMoving();
        }
    }

    public String inputGameCommand() {
        try {
            String gameCommand = inputView.readGameCommand();
            inputValidator.GameCommand(gameCommand);
            return gameCommand;
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return inputGameCommand();
        }
    }
}
