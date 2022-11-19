package bridge.controller;

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

    public static String getUserSelection() {
        try {
            outputView.printMoveInput();
            return inputView.readMoving();
        } catch (IllegalArgumentException exception) {
            outputView.printErrorMessage(exception);
            return getUserSelection();
        }
    }

    public static String getGameCommand() {
        outputView.printGameCommandInput();
        return inputView.readGameCommand();
    }
}
