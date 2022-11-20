package bridge.controller;

import bridge.view.InputView;
import bridge.view.OutputView;

public class InputController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public int inputBridgeSize() {
        outputView.printRequestBridgeSizeInput();
        int bridgeSize = inputView.readBridgeSize();
        return bridgeSize;
    }

    public String selectMoving() {
        try {
            outputView.printSelectUpOrDownInput();
            String readMoving = inputView.readMoving();
            return readMoving;
        } catch (IllegalArgumentException illegalArgumentException) {
            outputView.printExceptionMessage(illegalArgumentException);
            return selectMoving();
        }
    }

    public String selectRetryGame() {
        try {
            outputView.printSelectRetryOrNotInput();
            String selectRetryingGame = inputView.readGameCommand();
            return selectRetryingGame;
        } catch (IllegalArgumentException illegalArgumentException) {
            outputView.printExceptionMessage(illegalArgumentException);
            return selectRetryGame();
        }
    }
}