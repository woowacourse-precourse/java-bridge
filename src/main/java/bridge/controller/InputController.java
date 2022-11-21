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
            String readMoving = inputMovingByUser();
            return readMoving;
        } catch (IllegalArgumentException illegalArgumentException) {
            outputView.printExceptionMessage(illegalArgumentException);
            return selectMoving();
        }
    }

    private String inputMovingByUser() {
        outputView.printSelectUpOrDownInput();
        String inputMoving = inputView.readMoving();
        return inputMoving;
    }

    public String selectRetryGame() {
        try {
            String selectRetryingGame = inputRetryingByUser();
            return selectRetryingGame;
        } catch (IllegalArgumentException illegalArgumentException) {
            outputView.printExceptionMessage(illegalArgumentException);
            return selectRetryGame();
        }
    }

    private String inputRetryingByUser() {
        outputView.printSelectRetryOrNotInput();
        String selectRetryingGame = inputView.readGameCommand();
        return selectRetryingGame;
    }
}