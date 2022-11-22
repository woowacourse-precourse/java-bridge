package bridge.utils;

import bridge.utils.validators.BridgeSizeValidator;
import bridge.utils.validators.GameCommandValidator;
import bridge.utils.validators.MovingValidator;
import bridge.view.InputView;
import bridge.view.OutputView;

public class InputHandler {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public int getBridgeSize() {
        try {
            String size = inputView.readBridgeSize();
            new BridgeSizeValidator(size);
            return Integer.parseInt(size);
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            return getBridgeSize();
        }
    }

    public String getMoving() {
        try {
            String moving = inputView.readMoving();
            new MovingValidator(moving);
            return moving;
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            return getMoving();
        }
    }

    public String getGameCommand() {
        try {
            String gameCommand = inputView.readGameCommand();
            new GameCommandValidator(gameCommand);
            return gameCommand;
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            return getGameCommand();
        }
    }
}
