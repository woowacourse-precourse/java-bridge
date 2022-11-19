package utils;

import utils.validators.BridgeSizeValidator;
import utils.validators.GameCommandValidator;
import utils.validators.MovingValidator;
import view.InputView;
import view.OutputView;

public class InputHandler {

    InputView inputView = new InputView();

    public int getBridgeSize() {
        try {
            String size = inputView.readBridgeSize();
            new BridgeSizeValidator(size);
            return Integer.parseInt(size);
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            return getBridgeSize();
        }
    }

    public String getMoving() {
        try {
            String moving = inputView.readMoving();
            new MovingValidator(moving);
            return moving;
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            return getMoving();
        }
    }

    public String getGameCommand() {
        try {
            String gameCommand = inputView.readGameCommand();
            new GameCommandValidator(gameCommand);
            return gameCommand;
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            return getGameCommand();
        }
    }

}
