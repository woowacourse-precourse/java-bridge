package bridge.controller;

import bridge.model.GameCommand;
import bridge.model.Position;
import bridge.view.InputView;
import bridge.view.OutputView;

public class InputController {
    private static InputView inputView = new InputView();
    private static OutputView outputView = new OutputView();

    public static int getBridgeSize() {
        try {
            outputView.printBridgeSizeInput();
            return inputView.readBridgeSize();
        } catch (IllegalArgumentException exception) {
            outputView.printErrorMessage(exception);
            return getBridgeSize();
        }
    }

    public static Position getUserSelection() {
        try {
            outputView.printMoveInput();
            return Position.from(inputView.readMoving());
        } catch (IllegalArgumentException exception) {
            outputView.printErrorMessage(exception);
            return getUserSelection();
        }
    }

    public static GameCommand getGameCommand() {
        try {
            outputView.printGameCommandInput();
            return GameCommand.from(inputView.readGameCommand());
        } catch (IllegalArgumentException exception) {
            outputView.printErrorMessage(exception);
            return getGameCommand();
        }
    }
}
